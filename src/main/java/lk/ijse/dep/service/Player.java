package lk.ijse.dep.service;

public abstract class Player {

    // ====== Protected Field ======
    protected final Board board;

    // ====== Constructor ======
    public Player(Board board) {
        this.board = board; // Initialize with the respective argument
    }

    // ====== Abstract Method ======
    public abstract void movePiece(int col);
}
