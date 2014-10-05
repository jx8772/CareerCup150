package chapter18;
import java.util.Random;

/**
 * Problem: Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen.
 * Created by xiangji on 9/16/14.
 */
public class Question3 {
    public static void main(String[] args){
        doTest();
    }

    public static void doTest(){
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] dist = new int[10];
        int testSize = 100000;
        for(int i = 0; i < testSize; i++){
            int[] set = pickM(cards, 5);
            for(int j = 0; j < 5; j++){
                dist[set[j]]++;
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.println(dist[i]);
        }
    }

    public static int rand(int min, int max){
        Random random = new Random();
        int randNum = random.nextInt(max-min+1) + min;
        return randNum;
    }

    public static int[] pickM(int[] original, int m){
        int[] res = new int[m];
        int[] array = original.clone();

        for(int i = 0; i < m; i++){
            int index = rand(i, array.length-1);
            res[i] = array[index]; //original[index] is chosen
            array[index] = array[i]; //original[index] is replaced with original[i], original[i] is marked as dead (throw away original[index])
        }
        return res;
    }

}
