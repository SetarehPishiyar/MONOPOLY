package MONOPOLY;
public class Railroad extends Square {

    public Railroad(Player currentPlayer){
        currentPlayer.money -= 100;
    }

}
