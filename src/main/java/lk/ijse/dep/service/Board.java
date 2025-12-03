package lk.ijse.dep.service;

public interface Board {

    /**
     * Returns the UI object to communicate with the JavaFX front-end.
     */
    BoardUI getBoardUI();

    /**
     * Updates the board by placing the given piece in the specified column.
     * Assumes the move is legal.
     */
    void updateMove(int col, Piece move);

    /**
     * Finds the next available (empty) row in the given column.
     * Returns −1 if the column is full.
     */
    int findNextAvailableSpot(int col);

    /**
     * Checks whether the given column can accept another piece.
     */
    boolean isLegalMove(int col);

    /**
     * Checks whether there is at least one legal move remaining on the board.
     */
    boolean existLegalMoves();

    /**
     * Determines if either player has won.
     * Returns a Winner instance describing the winner or Piece.EMPTY if none.
     */
    Winner findWinner();
}
