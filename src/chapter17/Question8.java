package chapter17;

/**
 * Problem: You are given an array of integers,(both positive and negative). Find the contiguous sequence with the largest sum. Return sum
 * Created by xiangji on 9/10/14.
 */
public class Question8 {
    public static void main(String[] args){
        int[] test1 = {2,3,-8,-1,2,4,-2,3};
        int[] test2 = {2,-8,3,-2,4,-10};
        int[] test3 = {-4,-2,-3};
        System.out.println(largestSeq(test3));
    }

    public static int largestSeq(int[] s){
        int len = s.length;
        if(len <= 0){
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < len; i++){
            sum += s[i];
            if(sum > maxSum){
                //update max sum
                maxSum = sum;
            }
            if(sum < 0){
                //ignore the sequence so far
                sum = 0;
            }
        }
        return maxSum;
    }
}
