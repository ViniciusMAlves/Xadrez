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

        while (!chessMatch.getCheckMate()){
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

                if (chessMatch.getPromoted() != null) {
                    System.out.print("Digite a peça para promoção (B/H/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("H") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Valor invalido, Digite a peça para promoção (B/H/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePronotedPiece(type);
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
        UI.clearScreen();
        UI.printMatch(chessMatch,captured);
    }
}
