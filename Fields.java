package MONOPOLY;

public class Fields extends Property {
    private Player holder;
    private int price;
    private House[] houses = new House[4];
    private Hotel hotel;

    public Fields(int index, int price, int rent) {
        super(index, 100, rent);
    }

    public int getNumHouses(){
        int count=0;
        for(int i=0; houses[i] != null; i++)
            count++;
        return count;
    }

    public int getNumHotels(){
        if(hotel == null)
            return 0;
        return 1;
    }

    //when owner builds a new house ( more than one ) this method should be called.
    public void increaseRent() {
        if(getNumHouses() == 1)
            return;
        setRent(getRent() + 100);
    }

    //when owner builds a new house ( more than one ) or hotel this method should be called.
    public void increasePrice() {
        if(getNumHouses() == 0)
            return;
        setPrice(getPrice() + 150);
    }

    public void build(Player currentPlayer) {
        int j=0;
        Fields[] field = new Fields[10];
        for(int i=0; i < currentPlayer.getNumFields(); i++) {
            if(currentPlayer.properties.get(i) instanceof  Fields) {
                field[j] = (Fields) currentPlayer.properties.get(i);
                j++;
            }
        }
        int maxHousesNum=0, minHousesNum=0;
        for(int i=0; i <= j; i++) {
            if(field[i].getNumHouses() > maxHousesNum)
                maxHousesNum = field[i].getNumHouses();
            if(field[i].getNumHouses() < minHousesNum)
                minHousesNum = field[i].getNumHouses();
        }
        if(maxHousesNum != minHousesNum) {
            if(this.getNumHouses() == maxHousesNum) {
                System.out.println("You can not build another house on this field until the number of houses on other fields reaches the number of houses on this field.");
                return;
            }
        }
        if(getNumHouses() < 4) {
            houses[getNumHouses()] = new House(index);
            currentPlayer.addMoney(-150);
            increaseRent();
            increasePrice();
            System.out.printf("Your House is built now! Now you have %d houses.\n", getNumHouses());
        } else if(getNumHouses() == 4 && getNumHotels() == 0) {
            hotel = new Hotel(index, getPrice()+100);
            currentPlayer.addMoney(-100);
            increasePrice();
            System.out.println("Your hotel is built now!");
        } else if(getNumHouses() == 4 && getNumHotels() == 1) {
            System.out.println("You can't add any house or hotel in your field!");
        }
    }
}
