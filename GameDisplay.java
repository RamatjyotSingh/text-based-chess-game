/**
   * GameDisplay.java
   *
   * @author Ramatjyot Singh, 7964553
   *
   * REMARKS: interface for displaying the game
   */
public interface GameDisplay {
    public int promptForOpponentDifficulty(int maxDifficulty);
    public Move promptForMove();
    public void displayBoard(ChessBoard board);
    public void summarizeMove(Move move, ChessPiece myPiece, ChessPiece enemyPiece);
    public void gameOver(int winner);
    public boolean promptPlayAgain();
}
