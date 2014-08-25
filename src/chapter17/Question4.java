package chapter17;

/**
 * Problem: Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator
 * Created by xiangji on 8/23/14.
 */
public class Question4 {
    public static void main(String[] args){
        System.out.println(findMax(9,9));
    }

    /*if a-b overflows, this program will fail*/
    public static int findMax(int a, int b){
        int c = sign(a-b);
        int d = flip(c);
        return a*c + b*d;
    }

    /*get the sign of i: if i is positive or 0 return 1; otherwise return 0*/
    public static int sign(int i){
        //assume the integer is 32-bit
        return ((i >>> 31) ^ 1); //>>> shifts a zero into the leftmost position
    }

    /*if i is 1, return 0; if i is 0, return 1*/
    public static int flip(int i){
        //assume the integer is 32-bit
        return (i ^ 1);
    }
}
