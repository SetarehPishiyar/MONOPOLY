package MONOPOLY;
public class Jail extends Square {


    public void sendToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
        System.out.println("Player " + jailedPlayer.getName() + " is in jail now for the next 5 turns.");
    }
    public void free(Player jailedPlayer){
        jailedPlayer.inJail = false;
        jailedPlayer.addMoney(-50);
        jailedPlayer.turnsInJail = 0;
        System.out.println("Player " + jailedPlayer.getName() + " is free now.");
    }
    public void freeByTurns(Player jailedPlayer){
        jailedPlayer.inJail = false;
        jailedPlayer.turnsInJail = 0;
        System.out.println("Player " + jailedPlayer.getName() + " is free now.");
    }

}
