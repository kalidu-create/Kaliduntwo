package lk.ijse.dep.service;

public class BoardImpl implements Board {

    // ===== Constants =====
    public static final int NUM_OF_COLS = 6;
    public static final int NUM_OF_ROWS = 5;

    // ===== Fields =====
    private final BoardUI boardUI;
    private final Piece[][] pieces;

    // ===== Constructor =====
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        // Initialize all positions with Piece.EMPTY
        for (int col = 0; col < NUM_OF_COLS; col++) {
            for (int row = 0; row < NUM_OF_ROWS; row++) {
                pieces[col][row] = Piece.EMPTY;
            }
        }
    }

    // ===== Get BoardUI =====
    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    // ===== findNextAvailableSpot =====
    @Override
    public int findNextAvailableSpot(int col) {
        for (int row = 0; row < NUM_OF_ROWS; row++) {
            if (pieces[col][row] == Piece.EMPTY) {
                return row; // return first empty row in that column
            }
        }
        return -1; // column is full
    }

    // ===== isLegalMove =====
    @Override
    public boolean isLegalMove(int col) {
        return findNextAvailableSpot(col) != -1;
    }

    // ===== existLegalMoves =====
    @Override
    public boolean existLegalMoves() {
        for (int col = 0; col < NUM_OF_COLS; col++) {
            if (isLegalMove(col)) return true;
        }
        return false;
    }

    // ===== updateMove =====
    @Override
    public void updateMove(int col, Piece move) {
        int row = findNextAvailableSpot(col);
        if (row != -1) {
            pieces[col][row] = move;
        }
    }

    // ===== findWinner =====
    @Override
    public Winner findWinner() {

        // Check horizontal wins
        for (int row = 0; row < NUM_OF_ROWS; row++) {
            for (int col = 0; col <= NUM_OF_COLS - 4; col++) {
                Piece p = pieces[col][row];
                if (p != Piece.EMPTY &&
                        p == pieces[col + 1][row] &&
                        p == pieces[col + 2][row] &&
                        p == pieces[col + 3][row]) {
                    return new Winner(p, col, row, col + 3, row);
                }
            }
        }

        // Check vertical wins
        for (int col = 0; col < NUM_OF_COLS; col++) {
            for (int row = 0; row <= NUM_OF_ROWS - 4; row++) {
                Piece p = pieces[col][row];
                if (p != Piece.EMPTY &&
                        p == pieces[col][row + 1] &&
                        p == pieces[col][row + 2] &&
                        p == pieces[col][row + 3]) {
                    return new Winner(p, col, row, col, row + 3);
                }
            }
        }

        // No winner yet
        return new Winner(Piece.EMPTY);
    }
}
