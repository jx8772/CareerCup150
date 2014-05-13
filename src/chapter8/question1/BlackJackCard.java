package chapter8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlackJackCard extends Card {
    public BlackJackCard (int c, Suit s) {
        super(c,s);
    }

    public int value () {
        if (isAce()) return 1;
        else if (isFaceCard()) return 10;
        else return faceValue;
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard () {
        return faceValue >= 11 && faceValue <= 13;
    }

    public int minValue() {
        if(isAce())
            return 1;
        else
            return value();
    }

    public int maxValue() {
        if(isAce())
            return 11;
        else
            return value();
    }
}
