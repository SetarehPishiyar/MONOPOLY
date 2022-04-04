package MONOPOLY;
public class Trophy extends Square{

    public Trophy(int index){
        super(index);
    }
    public void getTrophy(Player currentPlayer) {
        currentPlayer.addMoney(200);
    }
}
