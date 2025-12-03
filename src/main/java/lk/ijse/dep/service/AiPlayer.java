package lk.ijse.dep.service;

public class AiPlayer extends Player {

    // ===== Constructor =====
    public AiPlayer(Board board) {
        super(board);
    }

    // ===== Move Piece Logic =====
    @Override
    public void movePiece(int col) {

        int randomCol;

        // Pick a random column until we find one that can process a legal move
        do {
            randomCol = (int) (Math.random() * BoardImpl.NUM_OF_COLS);
        } while (!board.isLegalMove(randomCol));

        // 1️⃣ Update the board with AI's move (GREEN piece)
        board.updateMove(randomCol, Piece.GREEN);

        // 2️⃣ Notify the UI about the move (false = AI player)
        board.getBoardUI().update(randomCol, false);

        // 3️⃣ Check for a winner
        Winner winner = board.findWinner();

        if (winner.getWinningPiece() == Piece.GREEN || winner.getWinningPiece() == Piece.BLUE) {
            // If there is a winner (AI or Human)
            board.getBoardUI().notifyWinner(winner);
        } else if (!board.existLegalMoves()) {
            // If there are no legal moves left → tied match
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }
}
