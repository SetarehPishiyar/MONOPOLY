package MONOPOLY;
import java.util.Scanner;

public class MainGame {
    public void commands(String command){
        switch (command){
            case "create_game" -> creatGame;
            case "start_game" -> startGame();
            case "index" ->index();
            case "property" ->property();
            case  "time" ->time();
            case "rank" ->rank();
        }

    }
    public void createGame(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext){

        }
    }
    public void startGame(){}
    public int index(){

    }
    public //daraii
    property(){

    }
    public //time
    time(){

    }
    public int rank(){

    }




    public void startingTurn(){
    }
    public void buyNotOwnedRegion(){

    }
    public void colllectMortgage(){

    }
    public void exclusiveRight(){

    }
    public boolean isPlayerLost(){

    }
    public boolean endGame(){
        System.out.println("YOU WON");
        System.out.println("YOU LOST,X WON THE GAME"); //X esme winner

    }


}