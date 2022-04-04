package MONOPOLY;

public class Tax extends Square{

    public Tax(Player currentPlayer){
        super(17);
        currentPlayer.addMoney(-currentPlayer.money/10);
    }

}
