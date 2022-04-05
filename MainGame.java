package MONOPOLY;

import java.util.Scanner;

public class MainGame {
    Player[] players = new Player[20];
    Airport[] airports=new Airport[3];
    {
        airports[0]=new Airport(3);
        airports[1]=new Airport(11);
        airports[2]=new Airport(20);
    }
    Cinema[] cinemas=new Cinema[3];
    {
        cinemas[0]=new Cinema(4);
        cinemas[1]=new Cinema(8);
        cinemas[2]=new Cinema(15);
    }
    Trophy trophy=new Trophy(6);
    Tax tax=new Tax(17);
    Railroad railroads=new Railroad(3);
    Chance chance=new Chance(24);
    Jail jail=new Jail(13);
    Bank bank=new Bank(21);
    Fields[] fields=new Fields[8];
    {
        fields[0]=new Fields(2);
        fields[0]=new Fields(7);
        fields[0]=new Fields(9);
        fields[0]=new Fields(12);
        fields[0]=new Fields(14);
        fields[0]=new Fields(18);
        fields[0]=new Fields(19);
        fields[0]=new Fields(23);

    }
    Dice dice=new Dice();
    Board theBoard=new Board(jail,dice);
    int numberOfPlayer = 0;
    boolean creatGame=false;
    int round=1;
    boolean isEnded=false;

    public void commands () {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch (command) {
            case "create_game" -> creatGame();
            case "start_game" -> startGame();
        }
    }

    private void creatGame () {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            players[numberOfPlayer]=new Player(sc.next());
            numberOfPlayer++;
        }
        creatGame=true;
    }
    public void playersCommand(Player currentPlayer){
        Scanner sc=new Scanner(System.in);
        String comm=sc.next();
        switch (comm){
            case "buy":currentPlayer.buy(theBoard.board[currentPlayer.index()].getClass());
//            case "build":currentPlayer
            case "sell":currentPlayer.sell2(currentPlayer.index());
        }
    }
    public void startGame () {
        if (!creatGame) {
            System.out.println("game was not created\n");
            return;
        }
        else {
            System.out.println("round "+round);
            while (!isEnded){
                for (int i=0;i<numberOfPlayer;i++){
                    System.out.println("It is"+players[i].getName()+"'s turn.");
                    int diceNumber=dice.Roll(players[i],theBoard);
                    play(players[i].index()+diceNumber,players[i]);


                }
            }

        }
    }
    public void play(int index,Player currentPlayer){
        switch (index){
//            case 2:
//            case 7:
//            case 9:
//            case 12:
//            case 14:
//            case 18:
//            case 19:
//            case 23:
            case 3:airports[0].offerBuyTicket(currentPlayer);
            case 11:airports[1].offerBuyTicket(currentPlayer);
            case 20:airports[2].offerBuyTicket(currentPlayer);
//            case 4:cinemas[]
//            case 8:
//            case 15:
            case 5,10,16:railroads.payMoney(currentPlayer);
            case 6:trophy.getTrophy(currentPlayer);
            case 17:tax.payTax(currentPlayer);
            case 24:chance.getChanceCard(currentPlayer,theBoard);
            case 21:
                bank.getBonus(currentPlayer);
                bank.offerInvest(currentPlayer);
        }
    }
    public int index () {

    }

    public int rank () {

    }


    public void startingTurn () {
    }

    public boolean isPlayerLost () {

    }
    public boolean endGame () {
        System.out.println("YOU WON");
        System.out.println("YOU LOST,X WON THE GAME"); //X esme winner

    }


}
