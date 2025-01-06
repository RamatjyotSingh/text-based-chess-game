
/**
   * ChessBoard.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to print and manipulate the chessboard
   */
public class ChessBoard {
    public final int BOARD_LENGTH = 8 ;
    public final int BOARD_WIDTH = 8 ;
    private ChessPiece [][] board;

    //constructor
    public ChessBoard(){

        generateBoard();

    }

    // generates and prints a new board
    public void generateBoard() {
        board = new ChessPiece[][] {
            {new Rook(false), new Knight(false), new Bishop(false), new Queen(false), new King(false), new Bishop(false), new Knight(false), new Rook(false)}, // Player 1 pieces
            {new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false), new Pawn(false)}, // Player 1 pawns
            {null, null, null, null, null, null, null, null}, // Empty rows
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true), new Pawn(true)}, // Player 2 pawns
            {new Rook(true), new Knight(true), new Bishop(true), new Queen(true), new King(true), new Bishop(true), new Knight(true), new Rook(true)} // Player 2 pieces
        };
        printBoard();
        
    }


    //prints the board hwile also initialising the row and col for each piece . helpful for initial board manipulation
     public void printBoard(){
        int counter =1;
        System.out.println("  1 2 3 4 5 6 7 8");

        for (int i = 0; i < BOARD_LENGTH; i++) {

            System.out.println("-------------------");
            System.out.print(counter+++"|");

            for (int j = 0; j < BOARD_WIDTH; j++) {

                if (board[i][j] != null) {

                    board[i][j].print(true);
                    
                    
                    board[i][j].setRow(i+1);
                    board[i][j].setCol(j+1);

                    System.out.print("|");

                } else {
                    System.out.print(" |");
                }
                                    
            }
            System.out.println();
        }
        System.out.println("-------------------");

     }

     //etter for board
     public ChessPiece[][] getBoard(){
        return board;
     }

     //getter for a specific piece based on cordinates
     public ChessPiece getPiece(int x, int y){
        x= x < 1 ? 1:x;
        x = x > board.length ? board.length : x;
        y= y < 1 ? 1:y;
        y = y > board.length ? board.length : y;
        
        return board[x-1][y-1];
     }

     //set the piece to a coordinate
     public void setPiece(int x, int y,ChessPiece piece){

        x= x < 1 ? 1:x;
        x = x > board.length ? board.length : x;
        y= y < 1 ? 1:y;
        y = y > board.length ? board.length : y;
        if(piece!=null){
            piece.setCol(y);
            piece.setRow(x);
        }
        board[x-1][y-1] = piece;
       
     }
    
    //  public boolean movePiece(int currX, int currY, int nextX, int nextY){
       
    //     //initiating ppossible enemy piece that could be captured
    //     ChessPiece enemyPiece = null;

    //     // //getting the coordinates of curr and future locations
    //     // int currX = move.getCurrRow() - 1;
    //     // int currY = move.getCurrColumn() - 1;
    //     // int nextX = move.getNextRow() - 1;
    //     // int nextY = move.getNextRow() - 1;

    //     ChessPiece myPiece=getPiece(currX,currY );//find the piecce to move

    //     boolean valid = myPiece.vaildateRange(nextX,nextY, board); // validate its range

    //     if(valid){

           

    //        if(myPiece.canCapture(nextX, nextY, board)){ // check if there is a possible enemy piece on the movable location

    //             enemyPiece = getPiece(nextX, nextY); // save the piece
    //             enemyPiece.toggleAlive();// make it dead

    //             board[nextX][nextY] = myPiece; // move our piece

    //             board[currX][currY]=null; // free the previous spot

    //        }

    //     }

    //     return valid;

    //  }

    
    // move the piece from the prev location to a new one
     public void move(ChessPiece piece, int currRow, int currCol, int nextRow, int nextColumn){
        setPiece(nextRow, nextColumn, piece);
        setPiece(currRow, currCol, null);
     }

}
