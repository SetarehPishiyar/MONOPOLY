package MONOPOLY;

public class Board {
    private final Square[] board = new Square[24];
    private static int X = 7;
    private static int Y = 7;
    public static void main(String[] args) {
        drawBoard();
    }


    public static void drawBoard() {
        for (int i = 0; i < Y*2+1 ; i++) {
            for (int j = 0; j < X*5; j++) {
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


}
