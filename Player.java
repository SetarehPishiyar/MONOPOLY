package MONOPOLY;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {

    private String name;
    public boolean inJail = false;
    public boolean invested = false;
    public int lendedMoney = 0;
    public int position;
    public Board board;
    protected int money = 1500;
    int turnsInJail=0;
    public ArrayList<Property> properties = new ArrayList<Property>();

    public Player(String name, Board board){
        this.name = name;
        position = 1;
        this.board = board;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int index() { return position; }

    public void setPosition(int position){
        this.position = position;
    }

    public String getName() { return name; }

    public int getMoney() { return money; }


    public void addMoney(int addMoney){

        doesntHaveEnoughMoney(this,-addMoney);
        this.money += addMoney;
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }


    public void moveTo(int position){
        if(position >= 25)
            position %= 24;

        this.position = position;

    }

    public void buyByProperty(Property property){
        if(!property.mortgaged) {

            addMoney(-property.getPrice());
            properties.add(property);
            property.setOwner(this);
            property.mortgaged = true;
        }
        else
            System.out.println("This property is mortgaged.");
    }

    public void buy(int index){
        if(board.getBoard()[index] instanceof Fields) {
            if(((Fields) board.getBoard()[index]).owner == null)
                this.buyByProperty((Fields)board.getBoard()[index]);
            else
                System.out.println("This property is bought.");
        }
        else if(board.getBoard()[index] instanceof Cinema) {
            if (((Cinema) board.getBoard()[index]).owner == null)
                this.buyByProperty((Cinema) board.getBoard()[index]);
            else
                System.out.println("This property is bought.");
        }
    }

    public void sellByProperty(Property property){
        properties.remove(property);
        property.mortgaged = false;
        addMoney(property.getPrice() / 2);
        property.setOwner(null);
    }
    public void sell (int index){
        if(board.getBoard()[index] instanceof Fields) {
            if(((Fields) board.getBoard()[index]).owner.equals(this))
                this.sellByProperty((Fields)board.getBoard()[index]);
            else
                System.out.println("You are not the owner.");
        }
        else if(board.getBoard()[index] instanceof Cinema) {
            if (((Cinema) board.getBoard()[index]).owner.equals(this))
                this.sellByProperty((Cinema) board.getBoard()[index]);
            else
                System.out.println("You are not the owner.");
        }
    }

    public void free(){
        inJail = false;
        addMoney(-50);
    }
    public void doesntHaveEnoughMoney(Player player,int price){
        if (player.money<price && !player.isLost(player)){
            System.out.println("It seems you dont have enough money \n sell something.");
            player.Property();
            System.out.println("What do you want to sell? enter the number");
            Scanner sc=new Scanner(System.in);
            int answer=sc.nextInt();
            player.sell(answer);
        }
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
        for (int i=0;i<properties.size();i++){
            System.out.println(i+"-"+properties.get(i).toString());
        }
        System.out.println("Your money: " + money + "$");
    }
    public boolean isLost(Player player){
        if (player.properties.size()==0 && player.money==0)
            return true;
        else return false;
    }
    //public ArrayList<Property> getHouseableProperties(){}

}
