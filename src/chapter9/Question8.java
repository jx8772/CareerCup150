package chapter9;

/**
 * Problem: Given an infinite number of quarters, dimes, nickels, and pennies, write code to calculate the number of ways of representing n cents
 * Created by xiangji on 9/29/14.
 */
public class Question8 {
    public static void main(String[ ] args){
        int ways = makeChange(100);
        return;
    }

    public static int makeChange(int amount){
        int[] denoms = {25,10,5,1};
        int[][] map = new int[amount+1][denoms.length];
        int ways = helper(amount, denoms, 0, map);
        return ways;
    }

    public static int helper(int amount, int[] denoms, int index, int[][] map){
        //if a value is precomputed, use the cached result directly
        if(map[amount][index] > 0){
            return map[amount][index];
        }
        if(amount == 0 || index == denoms.length-1){
            return 1;
        }
        int ways = 0;
        int denomAmount = denoms[index];
        for(int i = 0; i*denomAmount <= amount; i++){
            int remainAmount = amount-i*denomAmount;
            ways += helper(remainAmount, denoms, index+1, map);
        }
        //cache the result
        map[amount][index] = ways;
        return ways;
    }
}
