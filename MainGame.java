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
        fields[0]=new Fields(2,100,50);
        fields[1]=new Fields(7,100,50);
        fields[2]=new Fields(9,100,50);
        fields[3]=new Fields(12,100,50);
        fields[4]=new Fields(14,100,50);
        fields[5]=new Fields(18,100,50);
        fields[6]=new Fields(19,100,50);
        fields[7]=new Fields(23,100,50);

    }
    Board theBoard=new Board();
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
            players[numberOfPlayer]=new Player(sc.nextLine(),theBoard);
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
            while (!endGame()){
                System.out.println("round "+round);
                for (int i=0;i<numberOfPlayer;i++){
                    if (!players[i].isLost(players[i])){
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
                    else if (players[i].inJail){
                        players[i].addMoney(-10);
                        int DiceNum=diceNum();
                        if (DiceNum==1){
                            jail.free(players[i]);
                        }
                        else continue;
                    }


                }}
            }

        }
    }
    public void play(int index,Player currentPlayer){
        switch (index){
            case 2:{
                fields[0].offerBuying(fields[0],currentPlayer);
                fields[0].payRent(currentPlayer);
                //offer build
            }
            case 7:{
                fields[1].offerBuying(fields[1],currentPlayer);
                fields[1].payRent(currentPlayer);
            }
            case 9:{
                fields[2].offerBuying(fields[2],currentPlayer);
                fields[2].payRent(currentPlayer);
            }
            case 12:{
                fields[3].offerBuying(fields[3],currentPlayer);
                fields[3].payRent(currentPlayer);
            }
            case 14:{
                fields[4].offerBuying(fields[4],currentPlayer);
                fields[4].payRent(currentPlayer);
            }
            case 18:{
                fields[5].offerBuying(fields[5],currentPlayer);
                fields[5].payRent(currentPlayer);
            }
            case 19:{
                fields[6].offerBuying(fields[6],currentPlayer);
                fields[6].payRent(currentPlayer);
            }
            case 23:{
                fields[7].offerBuying(fields[7],currentPlayer);
                fields[7].payRent(currentPlayer);
            }
            case 3:airports[0].offerBuyTicket(currentPlayer);
            case 11:airports[1].offerBuyTicket(currentPlayer);
            case 20:airports[2].offerBuyTicket(currentPlayer);
            case 4:cinemas[0].offerBuying(cinemas[0], currentPlayer);
            cinemas[0].payRent(currentPlayer);
            case 8:
                cinemas[1].offerBuying(cinemas[1], currentPlayer);
                cinemas[1].payRent(currentPlayer);
            case 15:
                cinemas[2].offerBuying(cinemas[2], currentPlayer);
                cinemas[2].payRent(currentPlayer);
            case 5,10,16:railroads.payMoney(currentPlayer);
            case 6:trophy.getTrophy(currentPlayer);
            case 17:tax.payTax(currentPlayer);
            case 24:chance.getChanceCard(currentPlayer,theBoard);
            case 21:
                bank.getBonus(currentPlayer);
                bank.offerInvest(currentPlayer);
        }
        playersCommand(currentPlayer);
    }
    public void playersCommand(Player currentPlayer){
        System.out.println("you can ask your index.properties,and rank or just pass");
        Scanner sc=new Scanner(System.in);
        String comm=" ";
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
        for (Player p:players){
            if (p.rank==2){
                if (p.isLost(p)==true){
                    for (Player p1:players){
                        if (p1.rank==1){
                            System.out.println(p1.getName()+"\n YOU WON");
                            System.out.println(p.getName()+"\n YOU LOST,"+p1.getName()+"WON THE GAME");
                            for (Player p2:players){
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
for (int i=0;i<players1.length;i++){
    for (int j=i+1;j<players1.length;j++){
        if (players1[i].getWealth()<players1[j].getWealth()){
            Player temp=players1[i];
            players1[i]=players1[j];
            players1[j]=temp;
        }
    }
}


for (int i=0;i<players1.length;i++){
    players1[i].rank=i+1;
}
    }




}
