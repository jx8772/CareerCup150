package chapter18;

/**
 * Problem: add two numbers without using + - or * /
 * Extension: subtract two numbers and multiply two numbers
 * Created by xiangji on 9/14/14.
 */
public class Question1 {
    public static void main(String[] args){
        doTests();
    }

    public static void doTests(){
        int from = -100, to = 100;
        int i,j;
        for(i = from; i <= to; i++){
            doTest((0-i),negate(i));
            doTest(i*2,multiplyByTwo(i));
            if(isEven(i)){
                doTest(i/2,divideByTwo(i));
            }
        }

        for(i = from; i <= to; i++){
            for(j = from; j <= to; j++){
                doTest((i+j),add(i,j));
                doTest((i-j),subtract(i,j));
                doTest((i*j),multiply(i,j));
            }
        }
    }

    public static boolean doTest(int x, int y){
        if(x != y){
            System.out.println("test unsucessful");
            System.out.println(x);
            System.out.println(y);
            return false;
        }
        else{
            return true;
        }
    }

    /*words for both positive and negative numbers*/
    public static int add(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        //get the sum of digit without carry
        int digit = n1 ^ n2;
        //get the carry without digit addition
        int carry = (n1 & n2) << 1;
        return add(digit, carry);
    }

    public static int negate(int n){
        return add(~n, 1);
    }

    public static int subtract(int n1, int n2){
        return add(n1,negate(n2));
    }

    public static boolean isEven(int n){
        if((n&1) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int multiplyByTwo(int n){
        return (n << 1);
    }

    public static int divideByTwo(int n){
        return (n >> 1);
    }

    public static int multiply(int n1, int n2){
        int res = 0;
        if(n2 < 0){
            return multiply(negate(n1), negate(n2));
        }

        //if n2 >= 0
        while(n2 > 0){
            if(isEven(n2)){
                n1 = multiplyByTwo(n1);
                n2 = divideByTwo(n2);
            }
            else{
                //make n2 to be even
                res = add(res, n1);
                n2 =  add(n2, -1);
            }
        }
        return res;
    }
}
