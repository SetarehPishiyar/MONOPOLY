package MONOPOLY;

import java.util.ArrayList;

public class Board {
    private final Square[] board = new Square[25];

    public Jail jail;
    public Dice dice;

    public Board(Jail jail, Dice dice) {
        this.jail = jail;
        this.dice = dice;

        //creating all squares on the board
        for (int i = 1; i < 25; i++) {
            board[i] = createSquare(i);
        }
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

    private Square createSquare(int position) {
        switch (position) {
            case 1:
                return new Square(1);
            case 2:
                return new Fields(2, 100, 0);
            case 3:
                return new Airport(3);
            case 4:
                return new Cinema(4, 200, 25);
            case 5:
                return new Railroad(5);
            case 6:
                return new Trophy(6);
            case 7:
                return new Fields(7, 100, 0);
            case 8:
                return new Cinema(8, 200, 25);
            case 9:
                return new Fields(9, 100, 0);
            case 10:
                return new Railroad(10);
            case 11:
                return new Airport(11);
            case 12:
                return new Fields(12, 100, 0);
            case 13:
                jail.index = 13;
                return jail;
            case 14:
                return new Fields(14, 100, 0);
            case 15:
                return new Cinema(15, 200, 25);
            case 16:
                return new Railroad(16);
            case 17:
                return new Tax(17);
            case 18:
                return new Fields(18, 100, 0);
            case 19:
                return new Fields(19, 100, 0);
            case 20:
                return new Airport(20);
            case 21:
                return new Bank(21);
            case 22:
                return new Cinema(22, 200, 25);
            case 23:
                return new Fields(23, 100, 0);
            case 24:
                return new Chance(24);
            default:
                return null;
        }
    }
}
