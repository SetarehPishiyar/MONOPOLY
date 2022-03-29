package MONOPOLY;

import java.util.Scanner;

public class Dice {

    public int Roll(Player currentPlayer){

        Jail jail = new Jail();
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
                jail.sendToJail(currentPlayer);
            }
        }
        if(DiceNumber == 1){
            if(currentPlayer.inJail){
                jail.freeByTurns(currentPlayer);
            }
        }
        if(currentPlayer.inJail && DiceNumber!=1){
            currentPlayer.turnsInJail++;
            currentPlayer.addMoney(-10);
            if(currentPlayer.turnsInJail == 5) {
                jail.freeByTurns(currentPlayer);
            }
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
