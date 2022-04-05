package MONOPOLY;

import java.util.Scanner;

public class Jail extends Square {

    public Jail(int index){
        super(index);
    }
    public void sendToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
        System.out.println("Player " + jailedPlayer.getName() + " is in jail now.");
    }
    public void free(Player jailedPlayer){
        jailedPlayer.inJail = false;
        jailedPlayer.addMoney(-50);
        System.out.println("Player " + jailedPlayer.getName() + " is free now.");
    }
    public void offer(Player currentPlayer){
        System.out.println("you can pay 50$ and release from prison or stay there and pay 10$ for each round.\n enter free for releasing. ");
        Scanner sc=new Scanner(System.in);
        String answer=sc.next();
        if (answer.equalsIgnoreCase("free")){
            if (currentPlayer.money>100)
            free(currentPlayer);
            else {

            }
        }
    }



}