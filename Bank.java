package MONOPOLY;

import java.util.Scanner;

public class Bank extends Square{

    public Bank(int index){
        super(index);
    }

    public void offerInvest(Player currentPlayer){
        System.out.println("Do you want to invest? enter invest for investing or no");
        Scanner input = new Scanner(System.in);
        String answer = input.next();

        while (!answer.equalsIgnoreCase("invest") && !answer.equalsIgnoreCase("no")){
            System.out.println("invalid input. invest/no");
            answer = input.next();
        }

        if(answer.equalsIgnoreCase("invest")) {
            invest(currentPlayer);
        }
    }

    public void invest(Player currentPlayer){
        currentPlayer.lendedMoney = currentPlayer.money / 2;
        currentPlayer.money -= currentPlayer.lendedMoney;
        currentPlayer.invested = true;
    }

    public void getBonus(Player currentPlayer){

        if(currentPlayer.invested){
            currentPlayer.money += currentPlayer.lendedMoney*2;
            currentPlayer.lendedMoney = 0;
            currentPlayer.invested = false;
        }
        else
            System.out.println("You have no investment.");
    }
}
