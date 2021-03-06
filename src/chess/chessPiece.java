package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 * Created by desenv6 on 13/07/2021.
 */
public abstract class ChessPiece extends Piece{
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increseMoveCount(){
        moveCount++;
    }

    public void decreseMoveCount(){
        moveCount--;
    }

    public ChessPosition getChassPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean ifThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
