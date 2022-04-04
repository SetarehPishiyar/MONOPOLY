package MONOPOLY;
public class Trophy extends Square{

    public Trophy(Player currentPlayer) {
        super(6);
        currentPlayer.addMoney(200);
    }
}
