package chapter17;

/**
 * Problem: Write an algorithm which computes the number of trailing zeros in n factorial
 * Created by xiangji on 8/23/14.
 */
public class Question3 {
    public static void main(String[] args){
        System.out.println(countTrailZeros(10));
    }

    /*if k is 5, for 5, return 1, for 25 return 2 since 25 = 5*5 */
    public static int countMultiplesOfK (int i, int k){
        int count = 0;
        while(i % k == 0){
            count++;
            i = i/k;
        }
        return count;
    }

    public static int countTrailZeros(int num){
        if(num <= 0){
            return 0;
        }
        int multiplesOfTwo = 0;
        int multiplesOfFive = 0;
        for(int i = 1; i <= num; i++){
            multiplesOfFive += countMultiplesOfK(i, 5);
            multiplesOfTwo += countMultiplesOfK(i, 2);
        }
        return Math.min(multiplesOfFive, multiplesOfTwo);
    }
}
