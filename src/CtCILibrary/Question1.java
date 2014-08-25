package CtCILibrary;

/**
 * Problem: Write a function to swap a number in place without temporary variables
 * Created by xiangji on 8/22/14.
 */
public class Question1 {
    public static void main(String[] args){
        swap(5,7);
    }

    public static void swap(int a, int b){
        a = b - a; // difference between b and a
        b = b - a; // b is now a0
        a = a + b; // difference + a0 is b0
        System.out.println("after swap");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
