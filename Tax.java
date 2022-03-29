package MONOPOLY;

public class Tax extends Square{

    public Tax(Player currentPlayer){
        currentPlayer.money -= (currentPlayer.money/10);
    }

}
