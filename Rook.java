/**
   * Rook.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement gameplay for Rook
   */
class Rook extends ChessPiece{
    public Rook(boolean humanity){
        super(humanity);
    } 
   
    public boolean vaildateRange(int x, int y, ChessBoard board) {
        int row=getRow();
        int col=getCol();
        boolean ans = false;

        for (int i = 0; i < board.BOARD_LENGTH && y > 0 && y<=board.BOARD_LENGTH && x > 0 && x <= board.BOARD_LENGTH; i++) {
            
            // ans =  (y-- == col || y++ == col ) && (x++ == row || x-- == row);
            

            ans = x == row && y == col;
            if(!ans){
                if( y > col && row == x){
                   
                    y--;
               
                }
                else if( y < col && row == x){
                  
                    y++;
               
                }
                else if(x < row && y == col){
                    x++;
                   
               
                }
                else if(x > row && y == col){

                    x--; 
               
                }        
                ChessPiece possiblePiece = board.getPiece(x,y);

            if(possiblePiece!=null && !(row == x && col == y)  ) return false;
                
            }   
            
           
        }
        return ans;
    }

   
  


    public void print(boolean shortForm) {
        
        String piece="";

        if(shortForm){

            piece = getHumanity() ? "R":"r" ;

        }
        else{

            piece = "Rook";

        }
        System.out.print(piece);
    }

    
}