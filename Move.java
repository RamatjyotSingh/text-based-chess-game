/**
   * Move.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: an object to store Moves played during the game
   */
public class Move {
    private int currRow;
    private int currColumn;
    private int nextRow;
    private int nextColumn;

    //constructpr
    public Move(int currRow, int currColumn, int nextRow, int nextColumn) {

        this.currRow = currRow; 
        this.currColumn = currColumn; 
        this.nextRow = nextRow; 
        this.nextColumn = nextColumn; 
        
    }

    public void printMove(){
        System.out.printf(" moved from (%d,%d) to (%d,%d). ",currRow,currColumn,nextRow,nextColumn);
    }
    

    // public boolean promptMove(){
    //     Scanner scanner = new Scanner(System.in);
    //     boolean play = false;
    //     System.out.println("Please enter the row of the piece you would like to move.  Enter 0 to forfeit game.");
    //     int x = scanner.nextInt();
    //     if(0!=x){
    //         play = true;
    //         currRow=x;
    //         System.out.println("Please enter the column of the piece you would like to move.");
    //         currColumn = scanner.nextInt();

    //         System.out.println("Please enter the row of the destination.");
    //         nextRow = scanner.nextInt();

    //         System.out.println("Please enter the column of the piece you would like to move.");
    //         currColumn = scanner.nextInt();
    //         scanner.close();

    //     }
    //     return play;

    // }

    public int getCurrRow() {
        return currRow;
    }
    
    public int getCurrColumn() {
        return currColumn;
    }
    
    public int getNextRow() {
        return nextRow;
    }
    
    public int getNextColumn() {
        return nextColumn;
    }
    
}
