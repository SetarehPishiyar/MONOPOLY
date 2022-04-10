package MONOPOLY;

import java.util.Scanner;

public class Cinema extends Property {
    public Cinema(String name,int index) {
        super(name,index, 200, 25);
    }

    //when owner buys a new cinema this method should be called
    public void increaseRent(Player currentPlayer) {
        if(currentPlayer.getNumCinemas() == 1)
            return;
        setRent(getRent()*2);
    }

    @Override
    public void offerBuying(Property prop, Player currentPlayer){
        if (!prop.mortgaged){
            currentPlayer.doesntHaveEnoughMoney(currentPlayer, prop.getPrice());
            System.out.println("You can buy this cinema and earn money:) \n"+"Price:"+prop.getPrice()+"$\nwanna buy this cinema? enter buy or no");
            Scanner sc = new Scanner(System.in);
            String answer = sc.next();
            if (answer.equalsIgnoreCase("buy")){
                currentPlayer.buyByProperty(prop);
                increaseRent(currentPlayer);
            }
        }
    }
}