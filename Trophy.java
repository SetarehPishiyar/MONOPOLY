package MONOPOLY;
public class Trophy extends Square{

    public Trophy(String name,int index){
        super(name,index);
    }
    public void getTrophy(Player currentPlayer) {
        currentPlayer.addMoney(200);
        System.out.println("200$ Added to " + currentPlayer.getName() + "'s money. Congragulations.");
    }
}
