package MONOPOLY;

import java.util.Random;

public class Chance extends Square {


    public Chance(int index){
        super(index);}

    public void getChanceCard(Player currentPlayer, Board currentBoard) {

        Random input = new Random();
        int RanNum = input.nextInt(5) + 1;
        switch (RanNum) {
            case 1:
                currentPlayer.money += 200;
                break;
            case 2:
                currentBoard.jail.sendToJail(currentPlayer);
                break;
            case 3:
                currentPlayer.money -= (currentPlayer.money / 10);
                break;
            case 4:
                currentPlayer.moveTo(index + 3);
                break;
            case 5:
                currentBoard.jail.free(currentPlayer);
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