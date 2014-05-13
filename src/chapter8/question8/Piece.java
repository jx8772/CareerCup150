package chapter8.question8;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        if(this.color == Color.Black) {
            this.color = Color.White;
        } else if(this.color == Color.White) {
            this.color = Color.Black;
        }
    }

    public Color getColor() {
        return this.color;
    }
}
