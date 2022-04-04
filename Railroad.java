package MONOPOLY;
public class Railroad extends Square {

    public Railroad(int index){
        super(index);
    }
    public void payMoney(Player currentPlayer){
        currentPlayer.addMoney(-100);
    }

}
