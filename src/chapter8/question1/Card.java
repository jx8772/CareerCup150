package chapter8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 5:52 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Card {
    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public void print() {
        //print facevalue and suit
    }
}
