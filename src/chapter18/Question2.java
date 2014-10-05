package chapter18;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

/**
 * Problem: Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each of the 52!
 * permutations of the deck has to be equally likely. Assume that you are given a random number generate which is perfect.
 * Created by xiangji on 9/14/14.
 */
public class Question2 {
    public static void main(String[] args){
        ArrayList<Integer> deck = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        shuffleDeck(deck, deck.size());
        return;
    }

    /*this method can shuffle the first i cards in deck*/
    public static void shuffleDeck(ArrayList<Integer> deck, int i){
        if(i == 1){
            return;
        }
        //shuffle the first i-1 cards
        shuffleDeck(deck, i-1);
        //generate an index between 0 and i-1 (inclusive) for the last card to be inserted
        int index = randInt(0, i-1);
        int card = deck.remove(deck.size()-1);
        deck.add(index,card);
        return;
    }

    /*generate a random number between low and high, inclusive*/
    public static int randInt(int low, int high){
        Random random = new Random();
        /*random.nextInt(x) generates a number between 0 and x, exclusive*/
        int randomNum = random.nextInt(high-low+1) + low;
        return randomNum;
    }
}
