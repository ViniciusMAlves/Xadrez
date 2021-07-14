package application;

import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<ChessPiece>();

        while (true){
            try {
                UI.clearScreen();

                UI.printMatch(chessMatch, captured);
                System.out.print("Source: ");
                ChessPosition souce = UI.readChessPosition(sc);

                boolean[][] possibleMovies = chessMatch.possibleMoves(souce);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMovies);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(souce, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        //sc.close();
    }
}
