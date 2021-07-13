package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
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

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE),  new Position(7, 0));
        board.placePiece(new King(board, Color.BLACK),  new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE),  new Position(7, 4));
    }
}
