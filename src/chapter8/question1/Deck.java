package chapter8.question1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deck <T extends Card>{
    private ArrayList<T> cards;
    private int dealtIndex = 0; //mark the first undealt card 标注第一张没发过的牌的序号： 发过的牌的序号 < dealtIndex; 没发过牌的序号 >= dealtIndex

    public Deck () {

    }

    public void setDeckofCards(ArrayList<T> deckofcards) {
        cards = deckofcards;
    }

    public void shuffle() {

    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T dealCard() {
        if (remainingCards() == 0)
            return null;

        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;

        return card;
    }

    //deal cards to a person, number is the number of cards to be given
    public T[] dealHand(int number) {
        if(remainingCards() < number)
            return null;

        T[] hand = (T[])new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }

        return hand;
    }

    public void print () {
        //print all the cards in the deck
    }

}
