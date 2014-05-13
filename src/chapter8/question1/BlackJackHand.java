package chapter8.question1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 3/28/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlackJackHand extends Hand<BlackJackCard>{
    public BlackJackHand () {

    }

    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver)
                minOver = score;
            else if (score <= 21 && score > maxUnder)
                maxUnder = score;
        }
        //according to the rules, not very clear to me
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        if(cards.size() == 0)
            return scores;

        for (BlackJackCard c: cards) {
            addCardToScoreList(c, scores);
        }
        return scores;
    }

    private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        if(scores.size() == 0)
            scores.add(0);

        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            // ace can either be 1 or 11
            scores.set(i, score + card.minValue());
            if (card.minValue() != card.maxValue())
                scores.add(score + card.maxValue());
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public boolean isBlackJack() {
        if(cards.size() != 2)
            return false;
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return ((first.isAce() && second.isFaceCard()) || (first.isFaceCard() && second.isAce()));
    }

}
