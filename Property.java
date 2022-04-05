package MONOPOLY;

import java.util.Scanner;

public abstract class Property extends Square{
    //private String name;
    private int price;
    private int rent;
    protected Player owner;
    public boolean mortgaged = false;

    public Property(int index, int price, int rent){
        super(index);
        this.price = price;
        this.rent = rent;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public int getRent(){
        return rent;
    }

    public void setRent(int newRent){
        this.rent = newRent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player newOwner){
        owner = newOwner;
    }

//    public void bought(Player currentPlayer){
//        owner = currentPlayer;
//        currentPlayer.buy(this);
//    }
public void offerBuying(Property prop,Player currentPlayer){
    if (prop.mortgaged==false){
        System.out.println("You can buy this field and earn money:) \n"+"Price:"+prop.price+"\n wanna buy this field?(enter buy if you want.)");
        Scanner sc=new Scanner(System.in);
        String answer=sc.next();
        if (answer.equalsIgnoreCase("buy")){
            currentPlayer.buy(prop);
        }
        return;
    }
}
}
