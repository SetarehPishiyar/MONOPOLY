package MONOPOLY;

public class Tax extends Square{

    public Tax(int index){
        super(index);
    }
    public void payTax(Player currentPlayer){
        currentPlayer.addMoney(-currentPlayer.money/10);
    }

}
