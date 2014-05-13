package chapter8.question1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hand <T extends Card>{
    protected ArrayList<T> cards = new ArrayList<T>();

    //return the total value of all cards
    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }

        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {

    }

}
