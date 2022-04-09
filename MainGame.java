package MONOPOLY;

import java.util.Scanner;

public class MainGame {
    Player[] players = new Player[9];
    //    Airport[] airports=new Airport[3];
//    {
//        airports[0]=new Airport(3);
//        airports[1]=new Airport(11);
//        airports[2]=new Airport(20);
//    }
//    Cinema[] cinemas=new Cinema[3];
//    {
//        cinemas[0]=new Cinema(4);
//        cinemas[1]=new Cinema(8);
//        cinemas[2]=new Cinema(15);
//    }
//    Trophy trophy=new Trophy(6);
//    Tax tax=new Tax(17);
//    Railroad railroads=new Railroad(3);
//    Chance chance=new Chance(24);
//    Jail jail=new Jail(13);
//    Bank bank=new Bank(21);
//    Fields[] fields=new Fields[8];
//    {
//        fields[0]=new Fields(2,100,50);
//        fields[1]=new Fields(7,100,50);
//        fields[2]=new Fields(9,100,50);
//        fields[3]=new Fields(12,100,50);
//        fields[4]=new Fields(14,100,50);
//        fields[5]=new Fields(18,100,50);
//        fields[6]=new Fields(19,100,50);
//        fields[7]=new Fields(23,100,50);
//    }
    Board theBoard=new Board();
    int numberOfPlayer = 0;
    boolean creategame=false;
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
            System.out.println("enter players name and enter \"end\" at the end.");
            String name=" ";
            while (!name.equalsIgnoreCase("end")) {
                name=sc.next();
                players[numberOfPlayer]=new Player(name,theBoard);
                numberOfPlayer++;
            }
            players[numberOfPlayer]=null;
            numberOfPlayer--;

            if (numberOfPlayer<2 || numberOfPlayer>4){

                System.out.println("invalid,try again.");
                numberOfPlayer=0;
            }
            else {
                creategame=true;
                System.out.println("game was created.now start the game.");

                break;
            }
        }

    }
    public void startGame () {
        if (!creategame) {
            System.out.println("game was not created\n");
        }
        else {
            while (!endGame()){
                System.out.println("round "+round);
                for (int i=0;i<numberOfPlayer;i++){
                    if (!players[i].isLost(players[i])){
                        System.out.println("It is "+players[i].getName()+"'s turn.");
                        if (!players[i].inJail) {
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
                                        theBoard.jail.sendToJail(players[i]);
                                        theBoard.jail.offer(players[i]);
                                    }
                                    else {
                                        players[i].position+=diceNumber;
                                        play(players[i].position,players[i]);
                                    }
                                }
                            }
                        }
                        else if (players[i].inJail){
                            players[i].addMoney(-10);
                            int DiceNum=diceNum();
                            if (DiceNum==1){
                                theBoard.jail.free(players[i]);
                            }
                        }


                    }}
            }

        }
    }
    public void play(int index,Player currentPlayer){
        switch (index){
            case 2:{
                theBoard.fields2.offerBuying(theBoard.fields2,currentPlayer);
                theBoard.fields2.payRent(currentPlayer);
                //offer build
            }
            case 7:{
                theBoard.fields7.offerBuying(theBoard.fields7,currentPlayer);
                theBoard.fields7.payRent(currentPlayer);
            }
            case 9:{
                theBoard.fields9.offerBuying(theBoard.fields9,currentPlayer);
                theBoard.fields9.payRent(currentPlayer);
            }
            case 12:{
                theBoard.fields12.offerBuying(theBoard.fields12,currentPlayer);
                theBoard.fields12.payRent(currentPlayer);
            }
            case 14:{
                theBoard.fields14.offerBuying(theBoard.fields14,currentPlayer);
                theBoard.fields14.payRent(currentPlayer);
            }
            case 18:{
                theBoard.fields18.offerBuying(theBoard.fields18,currentPlayer);
                theBoard.fields18.payRent(currentPlayer);
            }
            case 19:{
                theBoard.fields19.offerBuying(theBoard.fields19,currentPlayer);
                theBoard.fields19.payRent(currentPlayer);
            }
            case 23:{
                theBoard.fields23.offerBuying(theBoard.fields23,currentPlayer);
                theBoard.fields23.payRent(currentPlayer);
            }
            case 3:theBoard.airport3.offerBuyTicket(currentPlayer);
            case 11:theBoard.airport11.offerBuyTicket(currentPlayer);
            case 20:theBoard.airport20.offerBuyTicket(currentPlayer);
            case 4:{
                theBoard.cinema4.offerBuying(theBoard.cinema4, currentPlayer);
                theBoard.cinema4.payRent(currentPlayer);}
            case 8:{
                theBoard.cinema8.offerBuying(theBoard.cinema8, currentPlayer);
                theBoard.cinema8.payRent(currentPlayer);}
            case 15:
            {theBoard.cinema15.offerBuying(theBoard.cinema15, currentPlayer);
                theBoard.cinema15.payRent(currentPlayer);}
            case 5:{theBoard.railroad5.payMoney(currentPlayer);}
            case 10:{theBoard.railroad10.payMoney(currentPlayer);}
            case 16:theBoard.railroad16.payMoney(currentPlayer);
            case 6:theBoard.trophy6.getTrophy(currentPlayer);
            case 17:theBoard.tax17.payTax(currentPlayer);
            case 24:theBoard.chance24.getChanceCard(currentPlayer,theBoard);
            case 21:{
                theBoard.bank21.getBonus(currentPlayer);
                theBoard.bank21.offerInvest(currentPlayer);}
        }
        playersCommand(currentPlayer);
    }
    public void playersCommand(Player currentPlayer){
        System.out.println("you can ask your index.properties,and rank or just pass");
        Scanner sc=new Scanner(System.in);
        String comm = sc.next();
        while (!comm.equalsIgnoreCase("pass")){
            switch (comm){
                case "index" :
                    System.out.println(currentPlayer.position);
                case "property":
                    currentPlayer.Property();
                case "rank":
                    rank();
                    System.out.println(currentPlayer.rank);
            }}
    }
    public boolean endGame () {
        rank();
        for (int i=0;i<numberOfPlayer;i++){
            Player p=players[i];
            if (p.rank==2){
                if (p.isLost(p)){
                    for (int j=0;j<numberOfPlayer;j++){
                        Player p1=players[j];
                        if (p1.rank==1){
                            System.out.println(p1.getName()+"\n YOU WON");
                            System.out.println(p.getName()+"\n YOU LOST,"+p1.getName()+"WON THE GAME");
                            for (int k=0;k<numberOfPlayer;k++){
                                Player p2=players[k];
                                if (p2!=p && p2!=p1){
                                    System.out.println(p2.getName()+"\n YOU LOST,"+p1.getName()+"WON THE GAME");

                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
    public int diceNum(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter your dice number:");
        int DiceNum=input.nextInt();
        if(!(DiceNum <= 6 && DiceNum >= 1)) {
            System.out.println("Enter a valid number 1 to 6");
            DiceNum = input.nextInt();
            diceNum();
        }
        return DiceNum;

    }
    public void rank(){
        Player[] players1=players;
        for (int i=0;i<numberOfPlayer-1;i++){
            for (int j=i+1;j<numberOfPlayer;j++){
                if (players1[i].getWealth()<players1[j].getWealth()){
                    Player temp=players1[i];
                    players1[i]=players1[j];
                    players1[j]=temp;
                }
            }
        }


        for (int i=0;i<numberOfPlayer;i++){
            players1[i].rank=i+1;
        }
    }




}