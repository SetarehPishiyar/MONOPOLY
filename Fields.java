package MONOPOLY;

import java.util.Scanner;

public class Fields extends Property {
    private int price;
    protected int NumOfHouses = 0;
    protected int NumOfHotels = 0;
    private House[] houses = new House[4];
    private Hotel hotel;

    public Fields(String name,int index, int price, int rent) {
        super(name,index, 100, 50);
    }

    public int getNumHouses(){
        return NumOfHouses;
    }

    public int getNumHotels(){
        return NumOfHotels;
    }

    //when owner builds a new house ( more than one ) this method should be called.
    public void increaseRent() {
        if(getNumHouses() == 0 && getNumHotels() == 0)
            setRent(50);
        if(getNumHouses() == 1)
            setRent(150);
        if(getNumHouses() == 2)
            setRent(250);
        if(getNumHouses() == 3)
            setRent(350);
        if(getNumHouses() == 4)
            setRent(450);
        if(getNumHouses() == 0 && getNumHotels() == 1)
            setRent(600);

    }

    //when owner builds a new house ( more than one ) or hotel this method should be called.
    public void increasePrice() {
        if(getNumHouses() == 0 && getNumHotels() == 0)
            price = 100;
        if(getNumHotels() == 1)
            price = 150;
        if(getNumHouses() == 2)
            price = 300;
        if(getNumHouses() == 3)
            price = 450;
        if(getNumHouses() == 4 )
            price = 600;
        if(getNumHouses() == 0 && getNumHotels() == 1)
            price = 800;

    }

    public void build(Player currentPlayer) {
        if(getNumHouses()<4){
            if(currentPlayer.NumofBuiltHouses <= 5) {
                houses[getNumHouses()] = new House("House", index);
                currentPlayer.addMoney(-150);
                NumOfHouses++;
                increasePrice();
                increaseRent();
                currentPlayer.NumofBuiltHouses++;
                System.out.println("Your house is built. you have " + NumOfHouses + " houses in this field and "+currentPlayer.NumofBuiltHouses + " houses in the game.");
            }
            else
                System.out.println("you can not add any houses. Each player can only build 5 houses in each game.");
        }
        else if(getNumHouses() == 4){
            hotel = new Hotel("Hotel",index);
            currentPlayer.addMoney(-100);
            NumOfHotels = 1;
            NumOfHouses = 0;
            increasePrice();
            increaseRent();
            System.out.println("Your hotel is build.");
        }
    }
    public void offerToBuild(Player currentPlayer,Fields field){

        if (currentPlayer.owns(field)) {
            if(field.NumOfHouses < 4) {
                System.out.println("You can build 4 houses in this field. you have " + NumOfHouses + " now.");
                System.out.println("Each house costs 150$ and you can get rent too.");
                System.out.println("enter build for a new house or pass to skip.");
            }
            else if(NumOfHouses == 4 && NumOfHotels == 0){
                System.out.println("You can build 4 houses in this field. you have " + NumOfHouses + " now.");
                System.out.println("Each hotel costs 800$ and you can get rent too.");
                System.out.println("enter build for a new hotel or pass to skip.");
            }
            else if(NumOfHotels == 1 && NumOfHouses == 0) {
                System.out.println("Your field is full.");
                System.out.println("Enter pass to skip.");
            }


            Scanner sc = new Scanner(System.in);
            String answer = sc.next();
            switch (answer){
                case "build":
                    build(currentPlayer);
                    break;
                case "pass":
                    break;
            }
        }
    }
}