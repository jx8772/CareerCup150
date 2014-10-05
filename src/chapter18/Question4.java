package chapter18;

/**
 * Problem: Write a method to count number of 2s between 0 and n
 * Created by xiangji on 9/16/14.
 */
public class Question4 {
    public static void main(String[] args){
        doTests();
    }

    public static void doTests(){
        int testSize = 500;
        for(int i = 9; i < testSize; i++){
            int v1 = count2SInRange(i);
            int v2 = count2SInRangeBruteForce(i);
            if(v1 != v2){
                System.out.println("test unsucessful");
                System.out.println(v1);
                System.out.println(v2);
            }
        }
    }

    public static int count2SInRange(int n){
        int count = 0;
        int len = String.valueOf(n).length();
        for(int i = 0; i < len; i++){
            count += count2SInRangeByDigit(n, i);
        }
        return count;
    }

    /*count the number of 2S in dth digit (d's index begins at 0 from right)*/
    public static int count2SInRangeByDigit(int n, int d){
        int digitValue = (n / power(10, d)) % 10;

        if(digitValue > 2){
            //roundUpByDigit(n, d+1) / power(10,d+1) * power(10,d)
            return roundUpByDigit(n, d+1)/10;
        }
        else if(digitValue < 2){
            //roundUpByDigit(n, digit) / power(10, d+1) * power(10,d)
            return roundDownByDigit(n, d+1) / 10;
        }
        else{
            int p1 = roundDownByDigit(n ,d+1) / 10;
            int p2 = n % power(10, d) + 1;
            return p1 + p2;
        }
    }

    public static int roundUpByDigit(int n, int d){
        return roundDownByDigit(n, d) + power(10,d);
    }

    public static int roundDownByDigit(int n, int d){
        return n - n % power(10,d);
    }

    public static int power(int n, int p){
        return (int)Math.pow(n,p);
    }

    public static int count2SInRangeBruteForce(int n){
        int count = 0;
        for(int i = 2; i <= n; i++){
            count += count2SInNumberBruteForce(i);
        }
        return count;
    }

    public static int count2SInNumberBruteForce(int n){
        int count = 0;
        while(n != 0){
            if(n%10 == 2){
                count++;
            }
            n = n / 10;
        }
        return count;
    }
}
