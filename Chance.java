package MONOPOLY;

import java.util.Random;

public class Chance extends Square {


    public Chance(String name,int index){
        super(name,index);}

    public void getChanceCard(Player currentPlayer, Board currentBoard) {

        Random input = new Random();
        int RanNum = input.nextInt(4) + 1;
        switch (RanNum) {
            case 1:
                System.out.println("You earned 200$.");
                currentPlayer.money += 200;
                break;
            case 2:
                System.out.println("Go to Jail.");
                currentBoard.jail.sendToJail(currentPlayer);
                currentBoard.jail.offer(currentPlayer);
                break;
            case 3:
                System.out.println("Pay tax.");
                currentPlayer.money -= (currentPlayer.money / 10);
                break;
            case 4:
                System.out.println("move 3 squares forward.");
                currentPlayer.moveTo(index + 3);
                break;

        }
    }

}