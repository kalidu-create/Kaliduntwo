package lk.ijse.dep.service;

public class HumanPlayer extends Player {

    // ===== Constructor =====
    public HumanPlayer(Board board) {
        super(board);
    }

    // ===== Move Piece Logic =====
    @Override
    public void movePiece(int col) {

        // 1. Check whether the move is legal
        if (board.isLegalMove(col)) {

            // 2. Update the board with the human player's move
            board.updateMove(col, Piece.BLUE);

            // 3. Notify the UI about the move (true → Human player)
            board.getBoardUI().update(col, true);

            // 4. Check whether there is a winner
            Winner winner = board.findWinner();

            if (winner.getWinningPiece() == Piece.BLUE || winner.getWinningPiece() == Piece.GREEN) {
                // 5. If there is a winner → notify the UI
                board.getBoardUI().notifyWinner(winner);

            } else if (!board.existLegalMoves()) {
                // 6. If no legal moves left → game is tied
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }
        // If the move is illegal → do nothing (UI will simply ignore)
    }
}
