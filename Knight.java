/**
   * Knight.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: to implement gameplay for Knight
   */
class Knight extends ChessPiece{

    public Knight(boolean humanity){
        super(humanity);
    } 

    public boolean vaildateRange(int x, int y, ChessBoard board) {
        int col = getCol();
        int row = getRow();
        ChessPiece possiblePiece = board.getPiece(x,y);
        boolean ans = false;
        if(possiblePiece != null && possiblePiece.getHumanity() == this.getHumanity()) return ans;
        
       
            if((x-2 == row&& y -1 == col) ||(x + 1 == row && y +2 == col) || (x + 2 == row && y +1 == col) || (x +1 == row && y -2 == col) ||(x +2 == row && y -1 == col) || (x-1 == row  && y +2 == col) || (x-2 == row  && y +1 == col) || (x-1 == row&& y -2 == col) ){
                // x-=2;
                // y--;

                ans = true;
           
            }
            // else if(x-1 == row&& y -2 == col){
            //     x-=2;
            //     y--;
           
            // }
            
            // else if(x-2 == row  && y +1 == col){
            //     x-=2;
            //     y++;
           
            // }
            // else if(x-1 == row  && y +2 == col){
            //     x-=2;
            //     y++;
           
            // }
            // else if(x +2 == row && y -1 == col){
            //     x+=2;
            //     y--;
           
            // }
            // else if(x +1 == row && y -2 == col){
            //     x+=2;
            //     y--;
           
            // }
            // else if(x + 2 == row && y +1 == col) {
            //     x+=2;
            //     y++;
            // }   
            // else if(x + 1 == row && y +2 == col) {
            //     ans =true;
            // }        
          
        
        return ans;
    }

   



    
    public void print(boolean shortForm) {
        
        String piece="";

        if(shortForm){

            piece = getHumanity() ? "N":"n" ;

        }
        else{

            piece = "Knight";

        }
        System.out.print(piece);
    }
    
}