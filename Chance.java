package MONOPOLY;

import java.util.Random;

public class Chance extends Square {


    public Chance(String name,int index){
        super(name,index);}

    public void getChanceCard(Player currentPlayer, Board currentBoard) {

        Random input = new Random();
        int RanNum = input.nextInt(5) + 1;
        switch (RanNum) {
            case 1:
                currentPlayer.money += 200;
                System.out.println("You earned 200$.");
                break;
            case 2:
                currentBoard.jail.sendToJail(currentPlayer);
                System.out.println("Go to Jail.");
                break;
            case 3:
                currentPlayer.money -= (currentPlayer.money / 10);
                System.out.println("Pay tax.");
                break;
            case 4:
                currentPlayer.moveTo(index + 3);
                System.out.println("move 3 squares forward.");
                break;
            case 5:
                if(currentPlayer.inJail) {
                    currentBoard.jail.free(currentPlayer);
                    currentPlayer.money += 50;
                    System.out.println("You are out of jail now");
                }
                else
                    System.out.println("You are not in jail.");
                break;
            case 6:
                //Dafe baad Tax nadim  BONUS
                break;
            case 7:
                //10$ to all players   BONUS
                break;
        }
    }

}