/**
   * ChessLogic.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement ChessController and build the underline logic for the game
   */

import java.util.InputMismatchException;

public class ChessLogic implements ChessController{

    private ChessDisplay display;
    private ChessBoard board;
    public static final int MAX_DIFFICULTY = 2;

    public ChessLogic(ChessDisplay display){

        this.display=display;
        board = new ChessBoard();


    }

    // Method to verify moves and move pieces around the chessboard .
    //
    // PARAMETERS:
    //    firstParameter  Move move -> Move which the human desires to play
    //    
    //
    // RETURNS:
    //    boolean value depending on whether the move was valid or not.
    
    public boolean movePiece(Move move) {
        

        //initiating ppossible enemy piece that could be captured
        ChessPiece enemyPiece = null;
        boolean valid =false;

         //getting the coordinates of curr and future locations
        int currX = move.getCurrRow() ;
        int currY = move.getCurrColumn() ;
        int nextX = move.getNextRow() ;
        int nextY = move.getNextColumn() ;

        ChessPiece myPiece=board.getPiece(currX,currY );//find the piece to move

        if(myPiece==null || !myPiece.getHumanity()) return valid; // if there no piece over the block or the user is attempting to access other players pieces, exit.
     

        valid  = myPiece.vaildateRange(nextX,nextY, board)  ; // validate its range

        
        enemyPiece = board.getPiece(nextX, nextY); // save the piece

        if(enemyPiece!=null) {
            enemyPiece.print(true);
            enemyPiece.toggleAlive();// make it dead
            valid = myPiece.canCapture(nextX, nextY, board); // placed here to makesure it doesnt capture its own allies
        }

        

        if(valid){
            
           

            board.move(myPiece, currX, currY, nextX, nextY); 
            
            myPiece = display.checkPromotion(myPiece,board);// check if the pawn is ready to promote

            display.summarizeMove(move, myPiece, enemyPiece); // summarize the move


        }


        return valid;

     }
    

     // method to reset the board
    public void reset() {
        board.generateBoard();

    }

    //method to begin the game
    // throws esception just in case if user enters unexpected input

    public void playGame() throws InputMismatchException {
      
        boolean playAgain;

        do{
            
            //save the king as they are the key to win
            King humanKing = (King)board.getPiece(8, 5);
            King AIKing = (King)board.getPiece(1, 5);

            int difficulty = display.promptForOpponentDifficulty(MAX_DIFFICULTY);

            while(humanKing.isAlive() && AIKing.isAlive()){// if any king is ded game is over

                ChessAI ai = new ChessAI(difficulty,display);

                Move move = getValidMove();
                if(move == null) break;
    
                display.displayBoard(board);

                ai.makeMove(move, board);
                display.displayBoard(board);

                
                

            }
            // print respective message based on who won
            if(!humanKing.isAlive()) {
                
                display.gameOver(display.AI_PLAYER);
                
            }

            else if(!AIKing.isAlive()){

                display.gameOver(display.HUMAN_PLAYER);
                
            }

            playAgain = display.promptPlayAgain();

            if(playAgain)
            // reset the oard before playing again
            reset();

        }while(playAgain);

    }

    /*helper method to get the valid move from user
    *  @returns move which the user gave
    */
 
    private Move getValidMove(){
        boolean valid = false;
        Move move = null;
        move = display.promptForMove();

        while(!valid && move != null){ //keep asking until valid is false , quit if opponent forefeited
            
            valid = movePiece(move);
            if(!valid){
                System.out.println("The move you have entered is invalid.  Please enter another move");
                move = display.promptForMove(); 
            }
    
        } 

        return move;
    }

    

}
