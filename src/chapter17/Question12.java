package chapter17;
import java.util.HashMap;

/**
 * Problem: Design an algorithm to find all pairs of integers within an array which sum to a specified value
 * Created by xiangji on 9/11/14.
 */
public class Question12 {
    public static void main(String[] args){
        int[] test = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
        printPairs(test, 12);
    }

    /*We assume that the numbers are distinct*/
    public static void printPairs(int[] array, int sum){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            int complement = sum - array[i];
            //if the complement is found in hash map, a pair is found
            if(map.containsKey(complement)){
                System.out.println(array[i] + " " + complement);
            }
            //if the current value is not in hash map, put it inside
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }
        }
    }
}
