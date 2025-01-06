/**
   * Queen.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement gameplay for Queen
   */
class Queen extends ChessPiece{
    public Queen(boolean humanity){
        super(humanity);
    } 
   
    public boolean vaildateRange(int x, int y, ChessBoard board) {
        int col = getCol();
        int row = getRow();

        Bishop range1 = new Bishop(getHumanity());
        Rook range2 = new Rook(getHumanity());

        range1.setRow(row);
        range1.setCol(col);

        range2.setRow(row);
        range2.setCol(col);

        return range1.vaildateRange(x, y, board) || range2.vaildateRange(x, y, board);
    }

   
   


    
    public void print(boolean shortForm) {
        
        String piece="";

        if(shortForm){

            piece = getHumanity() ? "Q":"q" ;

        }
        else{

            piece = "Queen";

        }
        System.out.print(piece);
    }
    
}