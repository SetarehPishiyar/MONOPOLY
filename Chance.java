package MONOPOLY;

import java.util.Random;

public class Chance extends Square {


    public Chance(String name, Player currentPlayer){
        super(name);
        Jail jail=new Jail;

        Random input = new Random();
        int RanNum = input.nextInt(7) + 1;
        switch (RanNum){
            case 1:
                currentPlayer.money+=200;
                break;
            case 2:
                jail.sendToJail(currentPlayer);
                break;
            case 3:
                currentPlayer.money -= (currentPlayer.money/10);
                break;
            case 4:
                currentPlayer.moveTo(index+3);
                break;
            case 5:
                //out of jail   BONUS
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