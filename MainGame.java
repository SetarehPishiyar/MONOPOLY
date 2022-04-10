package MONOPOLY;

import javax.swing.*;
import java.util.Scanner;

public class MainGame {
    Player[] players = new Player[9];

    Board theBoard=new Board();
    int numberOfPlayer = 0;
    boolean creategame=false;
    int round=0;
    boolean isEnded=false;

    public void StartMenu(){
        System.out.println("----Wellcome to MONOPOLY.----");
        theBoard.drawBoard();
    }
    public void commands () {
        System.out.println("Enter create_game to create a game and start_game to start the game.");
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
                System.out.println("game is created.now start the game.");

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
                round++;
                System.out.println("round "+round);
                for (int i=0;i<numberOfPlayer;i++){
                    if (!players[i].isLost){
                        System.out.println("It is "+players[i].getName()+"'s turn.");
                        System.out.println("You are now in " + players[i].index() + "th Square.");
                        if (!players[i].inJail) {
                            int diceNumber = diceNum();
                            players[i].moveTo(players[i].position + diceNumber);
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
                                        players[i].moveTo(players[i].position + diceNumber);
                                        theBoard.jail.sendToJail(players[i]);
                                        theBoard.jail.offer(players[i]);
                                    }
                                    else {
                                        players[i].moveTo(players[i].position + diceNumber);
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
                    }
                }
            }
        }
    }
    public void play(int index,Player currentPlayer){
        switch (index){
            case 2:{
                if(theBoard.fields2.owner == currentPlayer)
                    theBoard.fields2.offerToBuild(currentPlayer, theBoard.fields2);
                theBoard.fields2.offerBuying(theBoard.fields2,currentPlayer);
                theBoard.fields2.payRent(currentPlayer);
                break;
                //offer build
            }
            case 7:{
                if(theBoard.fields7.owner == currentPlayer)
                    theBoard.fields7.offerToBuild(currentPlayer, theBoard.fields7);
                theBoard.fields7.offerBuying(theBoard.fields7,currentPlayer);
                theBoard.fields7.payRent(currentPlayer);
                break;
            }
            case 9:{
                if(theBoard.fields9.owner == currentPlayer)
                    theBoard.fields9.offerToBuild(currentPlayer, theBoard.fields9);
                theBoard.fields9.offerBuying(theBoard.fields9,currentPlayer);
                theBoard.fields9.payRent(currentPlayer);
                break;
            }
            case 12:{
                if(theBoard.fields12.owner == currentPlayer)
                    theBoard.fields12.offerToBuild(currentPlayer, theBoard.fields12);
                theBoard.fields12.offerBuying(theBoard.fields12,currentPlayer);
                theBoard.fields12.payRent(currentPlayer);
                break;
            }
            case 14:{
                if(theBoard.fields14.owner == currentPlayer)
                    theBoard.fields14.offerToBuild(currentPlayer, theBoard.fields14);
                theBoard.fields14.offerBuying(theBoard.fields14,currentPlayer);
                theBoard.fields14.payRent(currentPlayer);
                break;
            }
            case 18: {
                if (theBoard.fields18.owner == currentPlayer)
                    theBoard.fields18.offerToBuild(currentPlayer, theBoard.fields18);
                theBoard.fields18.offerBuying(theBoard.fields18, currentPlayer);
                theBoard.fields18.payRent(currentPlayer);
                break;
            }
            case 19:{
                if(theBoard.fields19.owner == currentPlayer)
                    theBoard.fields19.offerToBuild(currentPlayer, theBoard.fields19);
                theBoard.fields19.offerBuying(theBoard.fields19,currentPlayer);
                theBoard.fields19.payRent(currentPlayer);
                break;
            }
            case 23:{
                if(theBoard.fields23.owner == currentPlayer)
                    theBoard.fields23.offerToBuild(currentPlayer, theBoard.fields23);
                theBoard.fields23.offerBuying(theBoard.fields23,currentPlayer);
                theBoard.fields23.payRent(currentPlayer);
                break;
            }
            case 3:theBoard.airport3.offerBuyTicket(currentPlayer);break;
            case 11:theBoard.airport11.offerBuyTicket(currentPlayer);break;
            case 20:theBoard.airport20.offerBuyTicket(currentPlayer);break;
            case 4:{
                theBoard.cinema4.offerBuying(theBoard.cinema4, currentPlayer);
                theBoard.cinema4.payRent(currentPlayer);
                break;
            }
            case 8:{
                theBoard.cinema8.offerBuying(theBoard.cinema8, currentPlayer);
                theBoard.cinema8.payRent(currentPlayer);
                break;
            }
            case 15:
            {theBoard.cinema15.offerBuying(theBoard.cinema15, currentPlayer);
                theBoard.cinema15.payRent(currentPlayer);
                break;
            }
            case 5:{theBoard.railroad5.payMoney(currentPlayer);break;}
            case 10:{theBoard.railroad10.payMoney(currentPlayer);break;}
            case 16:theBoard.railroad16.payMoney(currentPlayer);break;
            case 6:theBoard.trophy6.getTrophy(currentPlayer);break;
            case 17:theBoard.tax17.payTax(currentPlayer);break;
            case 24:theBoard.chance24.getChanceCard(currentPlayer,theBoard);break;
            case 21:{
                theBoard.bank21.getBonus(currentPlayer);
                theBoard.bank21.offerInvest(currentPlayer);
                break;
            }
            case 22:
                theBoard.cinema22.offerBuying(theBoard.cinema22, currentPlayer);
                theBoard.cinema22.payRent(currentPlayer);
                break;

        }
        playersCommand(currentPlayer);
    }
    public void playersCommand(Player currentPlayer){
        System.out.println("You have " + currentPlayer.money + "$");
        System.out.println("you can ask your index, property and rank or just pass");
        System.out.println("You can also sell your properties if you need money. enter sell if you want.");
        Scanner sc=new Scanner(System.in);
        String comm = sc.next();
        while (!comm.equalsIgnoreCase("pass")){
            switch (comm){
                case "index" :
                    System.out.println(currentPlayer.position);
                    break;
                case "property":
                    currentPlayer.Property();
                    break;
                case "rank":
                    rank();
                    System.out.println(currentPlayer.rank);
                    break;
                case "sell":
                    System.out.println("Enter index now.");
                    int index = sc.nextInt();
                    currentPlayer.sell(index);
                    break;
            }
            comm = sc.next();
        }
    }
    public boolean endGame () {
        rank();
        for (int i=0;i<numberOfPlayer;i++){
            Player p=players[i];
            if (p.rank==2){
                if (p.isLost){
                    for (int j=0;j<numberOfPlayer;j++){
                        Player p1=players[j];
                        if (p1.rank==1){
                            System.out.println(p1.getName()+"\n YOU WON");
                            System.out.println(p.getName()+"\n YOU LOST,"+p1.getName()+" WON THE GAME");
                            for (int k=0;k<numberOfPlayer;k++){
                                Player p2=players[k];
                                if (p2!=p && p2!=p1){
                                    System.out.println(p2.getName()+"\nYOU LOST,"+p1.getName()+"WON THE GAME");

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