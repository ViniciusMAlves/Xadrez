package boardgame;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

}
