package MONOPOLY;

import java.util.ArrayList;

public class Board {
    private final Square[] board = new Square[25];
    Square parking1=new Square(1);
    Fields fields2=new Fields(2, 100, 0);
    Airport airport3= new Airport(3);
    Cinema cinema4=new Cinema(4);
    Railroad railroad5=new Railroad(5);
    Trophy trophy6=new Trophy(6);
    Fields fields7=new Fields(7, 100, 0);
    Cinema cinema8=new Cinema(8);
    Fields fields9=new Fields(9, 100, 0);
    Railroad railroad10=new Railroad(10);
    Airport airport11=new Airport(11);
    Fields fields12=new Fields(12, 100, 0);
    Fields fields14=new Fields(14, 100, 0);
    Cinema cinema15=new Cinema(15);
    Railroad railroad16=new Railroad(16);
    Tax tax17=new Tax(17);
    Fields fields18=new Fields(18, 100, 0);
    Fields fields19=new Fields(19, 100, 0);
    Airport airport20=new Airport(20);
    Bank bank21=new Bank(21);
    Cinema cinema22=new Cinema(22);
    Fields fields23=new Fields(23, 100, 0);
    Chance chance24=new Chance(24);

    public Jail jail=new Jail(13);

    public Board(){

    }


//    public static void drawBoard() {
//        for (int i = 0; i < Y*2+1 ; i++) {
//            for (int j = 0; j < X*5; j++) {
//                if(i==7 && j==15){
//                    System.out.print("MONOPOLY");
//                    j+=8;
//                }
//                if(j%5==0 && ((j<=5 || j>=30) || (i<=2 || i>=12)))
//                    System.out.print("|");
//                if((i<=2 || i>=12) || (j<=4 || j>=30)){
//                    if(i%2 == 0)
//                        System.out.print("-");
//                    else
//                        System.out.print(" ");
//                }
//                else {
//                    System.out.print(" ");
//                    if(j == 25)
//                        System.out.print("    ");
//                }
//            }
//            System.out.println("|");}
//    }

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