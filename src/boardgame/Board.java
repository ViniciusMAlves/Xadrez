package boardgame;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class Board {
    private Integer rows;
    private Integer colunms;
    private Piece[][] pieces;

    public Board(Integer rows, Integer colunms) {
        if (rows < 1 || colunms < 1){
            throw new BoardException("E necessario que aja uma linha e uma coluna");
        }
        this.rows = rows;
        this.colunms = colunms;
        pieces = new Piece[rows][colunms];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColunms() {
        return colunms;
    }

    public Piece piece(int row, int column){
        if (!positionExists(row,column)){
            throw new BoardException("Posição não encontrada");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não encontrada");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardException("Ja a uma pesse nessa posição: "+ position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < colunms;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Posição não encontrada");
        }
        return piece(position) != null;
    }
}
