package MONOPOLY;

import java.util.Scanner;

public class Airport extends Square{

    public void fly(Player currentPlayer, int position) {
        currentPlayer.moveTo(position);
        currentPlayer.setPosition(position);
    }

    public void OfferBuyTicket(Player currentPlayer){
        System.out.println("Would you want to buy ticket? y/n");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        while (answer.equalsIgnoreCase("y") && answer.equalsIgnoreCase("n")){
            System.out.println("invalid input.");
            answer = input.next();
        }
        if (answer.equalsIgnoreCase("y"))
            buyTicket(currentPlayer);
    }

    public void buyTicket(Player currentPlayer){
        currentPlayer.money -= 50;
        System.out.println("Ticket Bought. Choose destination: (3 , 11 , 20)");
        Scanner input = new Scanner(System.in);
        int destination = input.nextInt();
        while ((destination != 3 && destination != 11 && destination != 20) || destination == currentPlayer.index()){
            System.out.println("invalid input. this destination is not an airport. choose another destination:");
            if(destination == currentPlayer.index())
                System.out.println("You are already here. choose another destination:");
            destination = input.nextInt();
        }
        fly(currentPlayer,destination);
    }
}
