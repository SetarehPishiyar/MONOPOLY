package MONOPOLY;

import java.util.ArrayList;

public class Board {
    private final Square[] board = new Square[25];
    Square parking1=new Square("parking[1]",1);
    Fields fields2=new Fields("fields[2]",2, 100, 0);
    Airport airport3= new Airport("airport[3]",3);
    Cinema cinema4=new Cinema("cinema[4]",4);
    Railroad railroad5=new Railroad("railroad[5]",5);
    Trophy trophy6=new Trophy("trophy[6]",6);
    Fields fields7=new Fields("fields[7]",7, 100, 0);
    Cinema cinema8=new Cinema("cinema[8]",8);
    Fields fields9=new Fields("fields[9]",9, 100, 0);
    Railroad railroad10=new Railroad("railroad[10]",10);
    Airport airport11=new Airport("airport[11]",11);
    Fields fields12=new Fields("fields[12]",12, 100, 0);
    Fields fields14=new Fields("fields[14]",14, 100, 0);
    Cinema cinema15=new Cinema("cinema[15]",15);
    Railroad railroad16=new Railroad("railroad[16]",16);
    Tax tax17=new Tax("tax[17]",17);
    Fields fields18=new Fields("fields[18]",18, 100, 0);
    Fields fields19=new Fields("fields[19]",19, 100, 0);
    Airport airport20=new Airport("airport[20]",20);
    Bank bank21=new Bank("bank[21]",21);
    Cinema cinema22=new Cinema("cinema[22]",22);
    Fields fields23=new Fields("fields[23]",23, 100, 0);
    Chance chance24=new Chance("chance[24]",24);

    public Jail jail=new Jail("jail[13]",13);

    public Board(){

    }


    public static void drawBoard() {
        for (int i = 0; i < 15 ; i++) {
            for (int j = 0; j < 35; j++) {
                if(i==7 && j==15){
                    System.out.print("MONOPOLY");
                    j+=8;
                }
                if(j%5==0 && ((j<=5 || j>=30) || (i<=2 || i>=12)))
                    System.out.print("|");
                if((i<=2 || i>=12) || (j<=4 || j>=30)){
                    if(i%2 == 0)
                        System.out.print("-");
                    else
                        System.out.print(" ");
                }
                else {
                    System.out.print(" ");
                    if(j == 25)
                        System.out.print("    ");
                }
            }
            System.out.println("|");}
    }

    public Square getBoard(int position) {
        switch (position) {
            case 1:
                return parking1;
            case 2:
                return fields2;
            case 3:
                return airport3;
            case 4:
                return cinema4;
            case 5:
                return railroad5;
            case 6:
                return trophy6;
            case 7:
                return fields7;
            case 8:
                return cinema8;
            case 9:
                return fields9;
            case 10:
                return railroad10;
            case 11:
                return airport11;
            case 12:
                return fields12;
            case 13:
                jail.index = 13;
                return jail;
            case 14:
                return fields14;
            case 15:
                return cinema15;
            case 16:
                return railroad16;
            case 17:
                return
                        tax17;
            case 18:
                return fields18;
            case 19:
                return fields19;
            case 20:
                return airport20;
            case 21:
                return bank21;
            case 22:
                return cinema22;
            case 23:
                return fields23;
            case 24:
                return chance24;
            default:
                return null;
        }
    }
}