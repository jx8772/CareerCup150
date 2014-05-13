package chapter8.question8;

public class Player {
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return Game.getInstance().getBoard().getScoreForColor(color);
    }

    public boolean playPiece(int row, int column) {
        return Game.getInstance().getBoard().placeColor(row, column, color);
    }
}
