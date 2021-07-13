package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class ChessPiece extends Piece{
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
