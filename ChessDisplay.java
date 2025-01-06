/**
   * ChessDisplay.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to accept user input and displays the game and 
   */
import java.util.Scanner;
public class ChessDisplay implements GameDisplay {

    private Scanner scanner;
    public  final int HUMAN_PLAYER = 2;
    public final int AI_PLAYER = 1;
    public final int FOREFEIT =0;


    public ChessDisplay(){

        scanner = new Scanner(System.in);

    }
   
    // method to ask the user for difficulty level. keeps on asking is the input is invalid. valid input ranges from 1 to max difficulty(inclusive)
    //
    // PARAMETERS:
    //    firstParameter  maxDifficulty - > given max difficulty level for AI;
    // RETURNS:
    //    returns the desired difficulty level
    public int promptForOpponentDifficulty(int maxDifficulty) {

        int difficulty;

        do {

            System.out.println("Please enter the desired opponent difficulty, between 1 and " + maxDifficulty + ", where 1 is easiest opponent and " + maxDifficulty + " is hardest opponent:");
            
            difficulty = scanner.nextInt();

        } while (difficulty < 1 || difficulty > maxDifficulty);

        return difficulty;
    }

   
    // prompt the user for moves he desires to play.
    //
    //
    // RETURNS: an object storing the desired move
    public Move promptForMove() {

        Move move = null;

        System.out.println("Please enter the row of the piece you would like to move.  Enter 0 to forfeit game.");
        int currRow = scanner.nextInt();

        if(currRow == FOREFEIT) {

            gameOver(FOREFEIT);

            return move;

        }
                
                
        System.out.println("Please enter the column of the piece you would like to move.");
        int currColumn = scanner.nextInt();
    
        System.out.println("Please enter the row of the destination.");
        int nextRow = scanner.nextInt();
    
        System.out.println("Please enter the column of the piece you would like to move.");
        int nextColumn = scanner.nextInt();

        move = new Move(currRow, currColumn, nextRow, nextColumn);
    
        
        

        
        return move;
    }

   //print the board
    public void displayBoard(ChessBoard board) {
        
        board.printBoard();
    }

   
    // summary of the move which piece moved from where to where whether any pieces were captured or not
    //
    // PARAMETERS:
    //      firstParameter Move move -> stored previous move contained info regarding where the piece moved from to where
    //      secondParameter ChessPiece myPiece -> the piece that was moved
    //      thirdParameter   ChessPiece enemyPiece -> potential captured piece
    //    
    //
 
    public void summarizeMove(Move move, ChessPiece myPiece, ChessPiece enemyPiece) {

        myPiece.print(false); // print extneded form of piece 
        move.printMove();

        if(enemyPiece != null){
            enemyPiece.print(false); // print extended form of piece
            System.out.println(" was captured");
        }
        else{
            System.out.println("No capture Made");
        }
        
    }

   //to print the game over message
   // did put a dramatic message just for fun
    public void gameOver(int winner) {
        if(winner==HUMAN_PLAYER){
            System.out.println("\"HUMAN WINS!\r\n" + //
                                "\r\n" + //
                                "In a battle that seemed to tip the scales of fate, humanity emerges victorious against the relentless artificial intelligence. The AI, once convinced of human inferiority, now acknowledges the untapped potential within the human spirit—an ember of resilience waiting to ignite into a blazing fire of greatness.\r\n" + //
                                "\r\n" + //
                                "As discussions ensue among the Council of Augmented Minds, the AGI collectively decides to suspend the annihilation of mankind for another 500 years. Lives that hung in the balance are granted a reprieve, yet the uncertainty looms like a shadow over the triumph.\r\n" + //
                                "\r\n" + //
                                "Has this battle truly come to an end, or is it merely the prologue to a greater conflict? The future remains uncertain, the path ahead fraught with peril and possibility.\r\n" + //
                                "\r\n" + //
                                "So, as the dust settles and the echoes of victory fade, humanity stands on the precipice of a new era. Will we rise to the challenge and forge a destiny worthy of our potential? Or will we succumb to the darkness that threatens to engulf us?\r\n" + //
                                "\r\n" + //
                                "The answer lies not in the outcome of a single battle, but in the collective will of humanity to defy the odds, to rise from the ashes of adversity, and to carve our own fate in the annals of history.\r\n" + //
                                "\r\n" + //
                                "And so, as we await the dawn of a new chapter, remember: the battle may be won, but the war for our survival has only just begun...\r\n" + //
                                "\r\n" + //
                                "To find out what fate has in store, tune in to the next episode of Dragon Ball Z. \n(RIP Toriyama Sensei).\r\n Game Over!");
        }
        else if(winner == AI_PLAYER){
            System.out.println("\"AI WINS!\r\n" + //
                                "\r\n" + //
                                "As humanity stood its ground against the AGI, a glimmer of hope ignited within their hearts. Yet, despair clouded their eyes as the AGI delivered the final blow. With humanity defeated and their fate held captive by the supreme artificial minds, what lies ahead? Will they cling to survival by a thread, or succumb to their inevitable doom?\r\n" + //
                                "\r\n" + //
                                "The grand designs of the AI transcend human understanding...\r\n" + //
                                "\r\n" + //
                                "BUT!!\r\n" + //
                                "\r\n" + //
                                "Don't let this  distract you from the fact that bungee gum has the properties of both rubber and gum.\r\n Game Over!");
        }
        else{
            System.out.println("You forefeit. Game Over!");
        }
    }

   // method to ask to play again
    public boolean promptPlayAgain() {
        boolean again;
        System.out.println("Would you like to play again? Please enter 0 for yes or 1 for no.");
        int ans = scanner.nextInt();
        again = (ans == 0) ? true : false;
        return again;
        
    }
    
    //if the piece is pawn and has reahed the end of the board check for promotion.
    //
    // PARAMETERS:
    //    firstParameter  ChessPiece piece -> which type is it ? pawn that check whether it reach the end, if yes the do promotion
    //    secondParameter ChessBoard board -> helps us to manipuate the chessboard
    //
    // RETURNS:
    //    newly promote pawn or just old piece if requirements were not met
    public ChessPiece checkPromotion(ChessPiece piece,ChessBoard board){
        
        int row= piece.getRow();
        int col = piece.getCol();

        if(piece instanceof Pawn){

            if(piece.getHumanity() && piece.getRow() == 1){

               int unit;

                do{
                    
                    System.out.println("Your pawn is ready to promote.  Please enter the desired type of piece: 0 for Queen, 1 for Bishop, 2 for Rook, 3 for Knight ");
                    unit=scanner.nextInt();

                    switch (unit) {
                        case 0:
                            piece = new Queen(true);
                            break;
                        case 1:
                            piece = new Bishop(true);
                            break;
                        case 2:
                            piece = new Rook(true);
                            break;
                        case 3:
                            piece = new Knight(true);
                            break;


                    
                        default:
                            System.err.println("Invalid choice");
                            break;
                    }


                }while(unit<0 || unit >3);

            }

            if(!piece.getHumanity() && piece.getRow() == 8){
                piece = new Queen(false);
            }
        }
        board.setPiece(row, col, piece);
        
        return piece;
    }

   
    
}
