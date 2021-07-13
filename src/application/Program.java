package application;

import boardgame.Position;
import chess.ChessMatch;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class Program {
    public static void main(String[] args){
        ChessMatch chessMatch = new ChessMatch();
       UI.printBoat(chessMatch.getPieces());
    }
}
