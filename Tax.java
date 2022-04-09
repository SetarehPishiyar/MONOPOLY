package MONOPOLY;

public class Tax extends Square{

    public Tax(String name,int index){
        super(name,index);
    }
    public void payTax(Player currentPlayer){
        currentPlayer.addMoney(-currentPlayer.money/10);
        System.out.println(currentPlayer.getName() + " paid " + currentPlayer.money/10 + "$ for tax.");
    }

}
