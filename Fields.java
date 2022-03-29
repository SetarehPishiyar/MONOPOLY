package MONOPOLY;

public class Fields extends Property {
    private Player owner;
    private int price;
    public int numOfHouses;
    private House[] houses = new House[4];
    private Hotel hotel;

    private void setPrice() {
        if(hotel != null) {
            price = 800;
            setRent(600);
            return;
        }
        int len=0;
        for(int i=0; houses[i] != null; i++)
            len++;
        price = 100 + len*150;
        setRent(50 + len*100);
        //----------
        // CINEMA
        //---------
    }

    public Fields(String name, int price, People holder, Player player) {
        super(name, player);
        this.price = price;
        this.holder = holder;
    }

    public People getHolder() {
        return holder;
    }

    public int getPrice() {
        return price;
    }

    public void depositMoney(double amount) {
        double oldMoney = holder.cashPossessions.getMoney();
        holder.cashPossessions.setMoney(oldMoney + amount);
    }

    public void build() {

    }

    public void sell(Fields utility) {
        depositMoney(price);
        int len=0;
        for(int i=0; getPlayer().utilities[i] != null; i++)
            len++;
        getPlayer().utilities[len-1] = null;
        len = 0;
        for (int i=0; Banker.utilities[i] != null; i++)
            len++;
        Banker.utilities[len] = utility;
    }

    public void buy(Fields utility) {
        withdrawMoney(price);
        int len=0;
        for(int i=0; getPlayer().utilities[i] != null; i++)
            len++;
        getPlayer().utilities[len] = utility;
        len = 0;
        for (int i=0; Banker.utilities[i] != null; i++)
            len++;
        Banker.utilities[len-1] = null;
    }

    public int getNumHouses(){}
    public int getNumHotels(){}

}

//override getrent