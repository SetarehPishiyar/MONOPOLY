package MONOPOLY;
public class Railroad extends Square {

    public Railroad(String name,int index){
        super(name,index);
    }
    public void payMoney(Player currentPlayer){
        System.out.println("rent price:100");
        if (currentPlayer.money>=100) {
            currentPlayer.addMoney(-100);
            System.out.println("You have paid your rent.");
        }
        else {
            System.out.println("You don't have enough money sell your properties.");
        }
    }

}
