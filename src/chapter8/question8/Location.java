package chapter8.question8;

public class Location {
    private int row;
    private int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isSameAs(int r, int c) {
        if(row == r && column == c)
            return true;
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
