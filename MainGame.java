package MONOPOLY;

import java.util.Scanner;

public class MainGame {
    Player[] players = new Player[4];
    Airport[] airports=new Airport[3];
    {
        airports[0]=new Airport(3);
        airports[1]=new Airport(11);
        airports[2]=new Airport(20);
    }
    Cinema[] cinemas=new Cinema[3];
    {
        cinemas[0]=new Cinema(4,200,25);
        cinemas[1]=new Cinema(8,200,25);
        cinemas[2]=new Cinema(15,200,25);
    }
    Trophy trophy=new Trophy(6);
    Tax tax=new Tax(17);
    Railroad railroads=new Railroad(3);
    Chance chance=new Chance(24);
    Jail jail=new Jail(13);
    Bank bank=new Bank(21);
    Fields[] fields=new Fields[8];
    {
        fields[0]=new Fields(2,100,50);
        fields[0]=new Fields(7,100,50);
        fields[0]=new Fields(9,100,50);
        fields[0]=new Fields(12,100,50);
        fields[0]=new Fields(14,100,50);
        fields[0]=new Fields(18,100,50);
        fields[0]=new Fields(19,100,50);
        fields[0]=new Fields(23,100,50);

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
            case "create_game" -> createGame();
            case "start_game" -> startGame();
        }
    }
    private void createGame() {
        Scanner sc = new Scanner(System.in);
        while (true){
        while (sc.hasNext()) {
            players[numberOfPlayer]=new Player(sc.next());
            numberOfPlayer++;
        }
        if (numberOfPlayer<2 || numberOfPlayer>4){
            System.out.println("invalid,try again.");
            numberOfPlayer=0;
        }
        else {
            creatGame=true;
            break;
        }
        }

    }
    public void startGame () {
        if (!creatGame) {
            System.out.println("game was not created\n");
            return;
        }
        else {
            while (!isEnded){
                System.out.println("round "+round);
                for (int i=0;i<numberOfPlayer;i++){
                    System.out.println("It is"+players[i].getName()+"'s turn.");
                    if (players[i].inJail==false) {
                        int diceNumber = diceNum();
                        players[i].position += diceNumber;
                        play(players[i].position, players[i]);
                        if (diceNumber == 6) {
                            Scanner sc = new Scanner(System.in);
                            System.out.println("You can play one more time.enter yes for playing and no for passing.");
                            String answer = sc.next();
                            if (answer.equalsIgnoreCase("no")) {
                                continue;
                            }
                            if (answer.equalsIgnoreCase("yes")) {
                                diceNumber = diceNum();
                                if (diceNumber == 6) {
                                    players[i].moveTo(13);
                                    jail.sendToJail(players[i]);
                                    jail.offer(players[i]);
                                }
                                else {
                                    players[i].position+=diceNumber;
                                    play(players[i].position,players[i]);
                                }
                            }
                        }
                    }
                    else if (players[i].inJail==true){
                        players[i].addMoney(-10);
                        int DiceNum=diceNum();
                        if (DiceNum==1){
                            jail.free(players[i]);
                        }
                        else continue;
                    }


                }
            }

        }
    }
    public void play(int index,Player currentPlayer){
        switch (index){
            case 2:{
                fields[0].offerBuying(fields[0],currentPlayer);
            }
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
    public void playersCommand(Player currentPlayer){
        Scanner sc=new Scanner(System.in);
        String comm=sc.next();
        switch (comm){
            case "buy":currentPlayer.buy(theBoard.board[currentPlayer.index()].getClass());
//            case "build":currentPlayer
            case "sell":currentPlayer.sell2(currentPlayer.index());
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
    public int diceNum(){
        Scanner input = new Scanner(System.in);
        int DiceNum=input.nextInt();
        if(!(DiceNum <= 6 && DiceNum >= 1)) {
            System.out.println("Enter a valid number 1 to 6");
            DiceNum = input.nextInt();
            diceNum();
        }
        return DiceNum;

    }


}
