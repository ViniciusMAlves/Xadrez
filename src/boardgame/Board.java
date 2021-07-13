package boardgame;

/**
 * Created by desenv6 on 13/07/2021.
 */
public class Board {
    private Integer rows;
    private Integer colunms;
    private Piece[][] pieces;

    public Board(Integer rows, Integer colunms) {
        this.rows = rows;
        this.colunms = colunms;
        pieces = new Piece[rows][colunms];
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColunms() {
        return colunms;
    }

    public void setColunms(Integer colunms) {
        this.colunms = colunms;
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
}
