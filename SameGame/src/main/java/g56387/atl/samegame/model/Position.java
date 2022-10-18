package g56387.atl.samegame.model;

/*
 * Represents the position of the board in the game
 * @author mohamed
 */
public class Position {

    private int row;
    private int column;

    /**
     * creates an instance of this Position class
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
