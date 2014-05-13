package chapter8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);

    private int value;
    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        switch (value) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }
}
