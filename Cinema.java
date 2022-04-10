package MONOPOLY;

import java.util.Scanner;

public class Cinema extends Property {
    public Cinema(String name,int index) {
        super(name,index, 200, 25);
    }

    //when owner buys a new cinema this method should be called
    public void increaseRent(Player currentPlayer) {
        for(Property p : currentPlayer.properties){
            if(p instanceof Cinema){
                if(currentPlayer.getNumCinemas() == 1)
                    p.setRent(25);
                if(currentPlayer.getNumCinemas() == 2)
                    p.setRent(50);
                if(currentPlayer.getNumCinemas() == 3)
                    p.setRent(100);
            }

        }
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
            }
            increaseRent(currentPlayer);
        }
    }
}