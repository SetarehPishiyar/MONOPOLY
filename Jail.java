package MONOPOLY;
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
    public void freeByTurns(Player jailedPlayer){
        jailedPlayer.inJail = false;
        System.out.println("Player " + jailedPlayer.getName() + " is free now.");
    }

    public void offer(Player currentPlayer){

    }


}
