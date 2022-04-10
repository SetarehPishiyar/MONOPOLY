package MONOPOLY;

import java.util.Scanner;

public class Airport extends Square{

    public Airport(String name,int index){
        super(name,index);
    }

    public void fly(Player currentPlayer, int position) {
        currentPlayer.moveTo(position);
        currentPlayer.setPosition(position);
        System.out.println("You are now in airport index "+ position );
    }

    public void offerBuyTicket(Player currentPlayer){
        System.out.println("Would you want to buy ticket? enter fly for buying or no");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        while (!answer.equalsIgnoreCase("fly") && !answer.equalsIgnoreCase("no")){
            System.out.println("invalid input.");
            answer = input.next();
        }
        if (answer.equalsIgnoreCase("fly"))
            buyTicket(currentPlayer);
    }

    public void buyTicket(Player currentPlayer){
        if(currentPlayer.getMoney()>=50){
        currentPlayer.addMoney(-50);
        System.out.println("Ticket Bought. Choose destination: (3 , 11 , 20)");
        Scanner input = new Scanner(System.in);
        int destination = input.nextInt();
        while ((destination != 3 && destination != 11 && destination != 20 || destination==currentPlayer.index()){
            if(destination == currentPlayer.index())
                System.out.println("You are already here. choose another destination:");
            else
                System.out.println("invalid input. this destination is not an airport. choose another destination:");
            destination = input.nextInt();
        }
        fly(currentPlayer,destination);
        }
        else
            System.out.println("You don't have enough money.");
    }
}
