package MONOPOLY;
public class Trophy extends Square{

    public Trophy(Player currentPlayer) {
        currentPlayer.money += 200;
    }
}
