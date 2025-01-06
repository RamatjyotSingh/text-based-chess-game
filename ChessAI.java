/**
   * ChessAI.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement an AI for chess
   */
import java.util.Random;
public class ChessAI implements ChessPlayer {

    public static final int AI_V1 =1;
    public static final int AI_V2 =2;
    private  Random random; // random will help us chose coordinates and pieces for AI
    private int difficulty;
    private ChessDisplay display;

    //constructor
    public ChessAI(int difficulty,ChessDisplay display){
        random= new Random(); 
        this.difficulty = difficulty;
        this.display=display;
    }

    // Makes the move for AI based on different strategies depending upon difficulty level chosen by the player
    //
    // PARAMETERS:
    //    firstParameter  Move move -> previous move played by the human
    //    secondParameter ChessBoard board -> helps to manipulate the chess board
    //
 
    public void makeMove(Move move, ChessBoard board) {
        ChessPiece piece;
        int nextRow;
        int nextColumn;
        
        do{
            piece = getRandomPiece( board);
            nextRow = random.nextInt(8) +1;
            nextColumn =  random.nextInt(8) +1;

            }while(!piece.vaildateRange(nextRow, nextColumn, board) || !piece.canCapture(nextRow, nextColumn, board));
        
        if(difficulty == AI_V1){
           createAIStage1( board,  piece, piece.getRow(),  piece.getCol(), nextRow, nextColumn );
         
          
        }
        else {
            createAIStage2(move,piece ,board, piece.getRow(),  piece.getCol(), nextRow, nextColumn);
        }
    }
    
    //helper method for strategy 1
    // this strategy just randomly choses pieces and then randomly choses one of their valid moves
    private void createAIStage1(ChessBoard board, ChessPiece piece, int currRow, int currCol, int nextRow, int nextColumn ){
       
        ChessPiece enemyPiece = board.getPiece(nextRow, nextColumn);
        board.move(piece, currRow, currCol, nextRow, nextColumn);
        Move newMove = new Move(currRow, currCol, nextRow, nextColumn);
        piece=display.checkPromotion(piece, board);

        display.summarizeMove(newMove,piece, enemyPiece);
    }

    //helper method for strategy 2 
    // doess what startegy 1 does but alongside would capture any opponent piece if available
    private void createAIStage2(Move move,ChessPiece piece,ChessBoard board,  int currRow, int currCol, int nextRow, int nextColumn){
        ChessPiece enemyPiece;
       
        Move newMove;
       
        ChessPiece newPiece = getPredator(move, board);
        
       if(newPiece==null) {

            enemyPiece= board.getPiece(nextRow, nextColumn);
            board.move(piece, currRow, currCol, nextRow, nextColumn);
            piece=display.checkPromotion(piece, board);
            newMove = new Move(currRow, currCol, nextRow, nextColumn);
            display.summarizeMove(newMove, piece, enemyPiece);
        }
        

    }

    //helper method to genreate random piece
    private ChessPiece getRandomPiece( ChessBoard board){
        ChessPiece piece;
        int currRow;
        int currCol;
        do{

            currRow = random.nextInt(8) + 1;
            currCol = random.nextInt(8) + 1;
    
            piece = board.getPiece(currRow, currCol);
           
                
        } while ((piece==null || piece.getHumanity()) );

        return piece;
    }

    // helper method for startegy2. finds the piece who can capture the previously moved unit
    //
    // PARAMETERS:
    //    firstParameter  Move move -> previous move played by the human
    //    secondParameter ChessBoard board -> for manipulating the chessboard
    // RETURNS:
    //   return the predator piece
    private ChessPiece getPredator(Move move, ChessBoard board){
        ChessPiece newPiece = null;
        int humanRow = move.getNextRow();
        int humanCol = move.getNextColumn();
        for (int i = 1; i <= board.BOARD_LENGTH; i++) {
            for (int j = 1; j <= board.BOARD_WIDTH; j++) {
                newPiece= board.getPiece(i,j);
                if(newPiece!= null && !newPiece.getHumanity() ){

                    if(newPiece.canCapture(humanRow,humanCol, board) && newPiece.vaildateRange(humanRow, humanCol, board) ){
                        
                        ChessPiece enemyPiece = board.getPiece(move.getNextRow(), move.getNextColumn());
                      
                        newPiece=display.checkPromotion(newPiece, board);
                        Move newMove = new Move(newPiece.getRow(), newPiece.getCol(),move.getNextRow(), move.getNextColumn());
                      
                        display.summarizeMove(newMove, newPiece, enemyPiece);
                        board.move(newPiece, i, j, humanRow, humanCol);

                        return newPiece;
                        
            
                    }

                }
            }
            
        }

        return null;
        
    }
}


