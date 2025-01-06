/**
   * King.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement gameplay for King
   */
class King extends ChessPiece{
    
    public King(boolean humanity){
        super(humanity);

    } 
   
    public boolean vaildateRange(int x, int y, ChessBoard board) {
        int col = getCol();
        int row = getRow();
        boolean ans = false;
        ChessPiece possiblePiece = board.getPiece(x,y);
        

        if(possiblePiece!=null && possiblePiece.getHumanity() == this.getHumanity() ) return  ans;
        if((x -1 == row && y -1 == col) ||(x -1 == row && y+1 == col) ||(x+1 == row && y -1 == col) || (x+1 == row && y+1 == col) || (row == x && col == y-1) ||  (row==x+1 && col == y )|| (row == x-1  && col ==y ) || (row == x && col == y+1)){
            ans = true;
       
        }
        
       
        
       
        return ans;
    }

   
    public void print(boolean shortForm) {
        
        String piece="";

        if(shortForm){

            piece = getHumanity() ? "K":"k" ;

        }
        else{

            piece = "King";

        }
        System.out.print(piece);
    }

    
}
