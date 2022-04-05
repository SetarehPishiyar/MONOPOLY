package MONOPOLY;
public class Cinema extends Property {
    public Cinema(int index) {
        super(index, 200, 25);
    }

    //when owner buys a new cinema ( more than one ) this method should be called
    public void increaseRent(Player currentPlayer) {
        if(currentPlayer.getNumCinemas() == 1)
            return;
        setRent(getRent()*2);
    }
}
