/**
   * ChessPiece.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: Abstract Chess Piece class to glue together different types of pieces
   */
public abstract class ChessPiece  {

    private boolean isAlive;
    private boolean isHuman;
    private int row;
    private int col;

    public ChessPiece(boolean humanity) {

        isHuman=humanity;
        isAlive = true;

    }

    // to validate the range of the piece, also makes sure it doesnt jump any pieces if it isnt supposed to
    // could have optimized it but lazy
    // PARAMETERS:
    //    firstParameter int x -> row of the move
    //    secondParameter int y -> col of the move
    //    thirdParameter ChessBoard board -> check range on this board  
    //
    // RETURNS:
    //    returns boolean value whether range is valid or not

    public abstract boolean vaildateRange(int x, int y, ChessBoard board);

    // to print the chess piece depending whether we just want their symbol or full name.
    //
    // PARAMETERS:
    //    firstParameter  boolean shortform -> decides whether to print only the symbol or full name 
    //
   
    public abstract void print(boolean shortForm);
   

    //determines whether the given coordinate can be captured or not
    //
    // PARAMETERS:
    //    firstParameter  int x-> row of the move
    //    secondParameter int y -> col of the move
    //    thirdParameter ChessBoard -> check on this board
    //
    // RETURNS:
    //    what is the meaning of the return value?
    public boolean canCapture(int x , int y, ChessBoard board){

            
            return vaildateRange(x, y, board) && board.getPiece(x,y)!=null && board.getPiece(x,y).isHuman != this.isHuman;
        
        
    }
    // Getter for isHuman
    public boolean getHumanity() {
        return isHuman;
    }

    public boolean isAlive(){
        return isAlive;
    }



    // Getter for row
    public int getRow() {
        return row;
    }

    // Setter for row
    public void setRow(int row) {
        this.row = row;
    }

    // Getter for col
    public int getCol() {
        return col;
    }

    // Setter for col
    public void setCol(int col) {
        this.col = col;
    }

    //change isAlive status
    public void toggleAlive(){
        isAlive = !isAlive;
    }

    
    
}

 




