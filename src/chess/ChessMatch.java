package chess;

import boardgame.Board;
import boardgame.Piece;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColunms()];
        for (int i = 0; i < board.getRows(); i++){
            for (int j = 0; j < board.getColunms(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
}
