package MONOPOLY;

import java.util.Scanner;

public abstract class Property extends Square{
    //private String name;
    private int price;
    private int rent;
    protected Player owner = null;
    public boolean mortgaged = false;

    public Property(String name, int index, int price, int rent){
        super(name,index);
        this.price = price;
        this.rent = rent;
    }

    public String getName(){
        return name;
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

    public void offerBuying(Property prop,Player currentPlayer){
        if (!prop.mortgaged){
            currentPlayer.doesntHaveEnoughMoney(currentPlayer,prop.price);
            System.out.println("You can buy this field and earn money:) \n"+"Price:"+prop.price+"$\nwanna buy this field? enter buy or no");
            Scanner sc=new Scanner(System.in);
            String answer=sc.next();
            if (answer.equalsIgnoreCase("buy")){
                currentPlayer.buyByProperty(prop);
            }
        }
    }
    public void payRent(Player currentPlayer){
        if (owner!=currentPlayer && owner!=null){
            currentPlayer.pay(owner,rent);
            if(rent!=0)
                System.out.println(rent + "$ paid to " + owner.getName() + " for rent.");
        }

    }
}
