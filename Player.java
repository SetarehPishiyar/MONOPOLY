package MONOPOLY;

import java.util.ArrayList;


public class Player {

    private String name;
    public boolean inJail = false;
    public boolean invested = false;
    public int lendedMoney = 0;
    public int turnsInJail = 0;
    private int index;
    protected int money = 1500;
    public ArrayList<Property> properties = new ArrayList<Property>();

    public Player(String name){
        this.name = name;
        index = 1;
    }

    public int index() { return index; }

    public void setPosition(int position){
        this.index = position;
    }

    public String getName() { return name; }

    public int getMoney() { return money; }


    public void addMoney(int addMoney){
        this.money += addMoney;
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }


    public void moveTo(int position){
        if(position >= 25)
            position %= 24;

        this.index = position;

    }

    public void buy(Property property){
        if(!property.mortgaged) {

            addMoney(-property.getPrice());
            properties.add(property);
            property.setOwner(this);
            property.mortgaged = true;
        }
        else
            System.out.println("This property is mortgaged.");
    }

    public void sell(Property property){
        properties.remove(property);
        property.mortgaged = false;
        addMoney(property.getPrice() / 2);
        property.setOwner(null);
    }
    public void sell2 (int position){

    }

    public void free(){
        inJail = false;
        addMoney(-50);
        turnsInJail = 0;
    }

    public void build(Fields currentField){
        if(currentField.getOwner().equals(this)){
            if(currentField.getNumHouses() < 4){
                currentField.numOfHouses++;
                addMoney(-150);
                currentField.setRent(currentField.getNumHouses()*100 + 50);
                currentField.setPrice(currentField.getPrice()+150);
                System.out.println("Your House is built now. Number of houses: " + currentField.getNumHouses());
            }
            else if(currentField.getNumHouses() == 4 && currentField.getNumHotels() == 0){
                addMoney(-100);
                currentField.setPrice(currentField.getPrice()+100);
                currentField.setRent(600);
                System.out.println("Your Hotel is built now.");
            }
            else
                System.out.println("You can not add any house or hotel.");
        }
        else
            System.out.println("Sorry this property doesn't belong to you.");

    }


    public void fly(int position) {
        this.moveTo(position);
        this.setPosition(position);
    }

    public boolean owns(Property property){

        if(property.owner.equals(this))
            return true ;
        else
            return false;
    }


    public int getNumCinemas(){
        int numCinemas = 0;
        for(Property p : properties){
            if(p instanceof Cinema){
                numCinemas++;
            }
        }
        return numCinemas;
    }

    public int getNumFields(){
        int numFields = 0;
        for(Property p : properties){
            if(p instanceof Fields){
                numFields++;
            }
        }
        return numFields;
    }

    public void Property(){
        System.out.println("Your properties:");
        System.out.println(this.properties);
        System.out.println("Your money: " + money + "$");
    }

    //public ArrayList<Property> getHouseableProperties(){}

}
