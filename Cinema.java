package MONOPOLY;
public class Cinema extends Property {
    public Cinema(String name, int price , int rent) {

        super(name,price,rent);
    }

/*    void getTicket() {
        if(getHolder() instanceof Banker || getPlayer().equals(getHolder()))
            setRent(0);
        else if(getHolder() instanceof Player && !getPlayer().equals(getHolder()))
            setRent(25 * getHolder().cinemas.length);
    }
    @Override
    public void buy(Fields utility) {
        withdrawMoney(getPrice());
        int len=0;
        for(int i=0; getPlayer().cinemas[i] != null; i++)
            len++;
        getPlayer().cinemas[len] = (Cinema) utility;
        len = 0;
        for (int i=0; Banker.cinemas[i] != null; i++)
            len++;
        Banker.cinemas[len-1] = null;
    }

    @Override
    public void sell(Fields utility) {
        depositMoney(getPrice());
        int len=0;
        for(int i=0; getPlayer().cinemas[i] != null; i++)
            len++;
        getPlayer().utilities[len-1] = null;
        len = 0;
        for (int i=0; Banker.cinemas[i] != null; i++)
            len++;
        Banker.cinemas[len] = (Cinema) utility;
    }*/
}
