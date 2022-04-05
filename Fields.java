package MONOPOLY;

import java.util.Scanner;

public class Fields extends Property {
    private House[] houses = new House[4];
    private Hotel hotel;

    public int getNumbersOfHouses() {
        int num=0;
        while (houses[num]!=null)
            num++;
        return num;
    }

    public Fields(int index , int price, int rent) {
        super(index, 100, rent);
    }

    //when owner builds a new house ( more than one ) this method should be called
    public void increaseRent() {
        setRent(getRent() + 100);
    }

    //when owner builds a new house ( more than one ) or hotel this method should be called.
    //this method returns the new price
    public int increasePrice() {
        return getPrice() + 150;
    }


/*    private void setPrice() {
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
    }*/
}