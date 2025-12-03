package lk.ijse.dep.service;

public interface BoardUI {

    /**
     * Updates the UI when a move is made.
     * @param col the column index where the piece was dropped
     * @param isHuman true if the move was made by the human player, false if by the AI
     */
    void update(int col, boolean isHuman);

    /**
     * Notifies the UI when a winner is found or the game ends in a tie.
     * @param winner the Winner instance (Piece.BLUE, Piece.GREEN, or Piece.EMPTY for tie)
     */
    void notifyWinner(Winner winner);
}
