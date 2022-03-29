package MONOPOLY;

public abstract class Property extends Square{
    private String name;
    private int price;
    private int rent;
    protected Player owner;
    public boolean mortgaged = false;

    public Property(String name, int price, int rent){
        super(name);
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

    public void bought(Player currentPlayer){
        owner = currentPlayer;
        currentPlayer.buy(this);
    }


    // offerBuy & doAction miss
}
