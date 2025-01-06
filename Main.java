/**
   * Main.java
   *
   * COMP 2150 SECTION A02
   * INSTRUCTOR    Emanuel Weins
   * ASSIGNMENT    Assignment 3, question 1
   * @author       Ramatjyot Singh, 7964553
   * @version      23/03/24
   *
   * REMARKS: To build a text based Chess prototype.
   */
public class Main {

    //main method to play the game
    public static void main(String[] args) {
   
        ChessLogic controller = new ChessLogic(new ChessDisplay());
        try{
            controller.playGame();
         }
         catch(Exception e){
             System.err.println("Error occured\n" + e.getMessage());
         }
    }
}
