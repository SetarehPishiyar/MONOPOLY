package MONOPOLY;

import java.util.Scanner;

public class Dice {

    public int Roll(Player currentPlayer, Board currentboard){

        Scanner input = new Scanner(System.in);
        int DiceNumber = input.nextInt();
        while (!isValid(DiceNumber)) {
            System.out.println("Enter a valid number 1 to 6");
            DiceNumber = input.nextInt();
        }
        if(DiceNumber == 6){
            currentPlayer.moveTo(currentPlayer.index() + 6);
            System.out.println("Bonus round:");
            DiceNumber = input.nextInt();
            while (!isValid(DiceNumber)) {
                System.out.println("Enter a valid number 1 to 6");
                DiceNumber = input.nextInt();
            }
            if (DiceNumber == 6){
                currentboard.jail.sendToJail(currentPlayer);
            }
        }
        if(DiceNumber == 1){
            if(currentPlayer.inJail){
                currentboard.jail.freeByTurns(currentPlayer);
            }
        }
        if(currentPlayer.inJail && DiceNumber!=1){
            currentPlayer.addMoney(-10);
        }
        return DiceNumber;
    }

    public boolean isValid(int DiceNum){
        if(DiceNum <= 6 && DiceNum >= 1)
            return true;
        else
            return false;
    }
}
