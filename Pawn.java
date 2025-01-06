/**
   * Pawn.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement gameplay for BPawn
   */

class Pawn extends ChessPiece{
    public Pawn(boolean humanity){
        super(humanity);
    } 
   
    public boolean vaildateRange(int x, int y, ChessBoard board) {

        boolean ans ;
        int row = getRow();
        int col = getCol();
        
        if(board.getPiece(x,y)!=null) {
            return canCapture(x, y, board);
        } 

        if(!getHumanity()) x--;

        else x++;

        ans = row <= board.BOARD_LENGTH  && row == x && col == y;


        return ans;
    }
    
  

   
   public boolean canCapture(int x , int y, ChessBoard board){
        int col = getCol();
        int row = getRow();
        if(board.getPiece(x, y)==null) return vaildateRange(x, y, board);
        boolean ans = board.getPiece(x, y).getHumanity() != this.getHumanity();

        if(!getHumanity()) return (row == x-1 && (col == y-1 || col == y+1)) && ans ;
        return   (row == x+1 && (col == y-1 || col == y+1)) &&  ans;
    }


    
   

    
    public void print(boolean shortForm) {

        String piece="";

        if(shortForm){

            piece = getHumanity() ? "P":"p" ;

        }
        else{

            piece = "Pawn";

        }
        System.out.print(piece);
    }

    


   

    
}