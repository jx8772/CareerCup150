package chapter7;

/**
 * Problem: Write methods to implement the multiply, subtract, and divide operations for integers. Use only add operator
 * Created by xiangji on 8/25/14.
 */
public class Question4 {
    public static void main(String[] args) throws Exception{
        System.out.println(flip(5));
        System.out.println(subtract(3,5));
        System.out.println(multiply(5,-6));
        System.out.println(divide(-21,-5));
    }

    /*flip an integer, -5 -> 5, 4 -> -4*/
    public static int flip(int i){
        int flip = 0;
        int sign = i > 0 ? -1 : 1;

        while(i != 0){
            flip += sign;
            i += sign;
        }
        return flip;
    }

    /*subtract b from a*/
    public static int subtract(int a, int b){
        return a + flip(b);
    }

    /*multiply a with b*/
    public static int multiply(int a, int b){
        if(a < b){
            return multiply(b, a); // we will add b for a times
        }
        int sum = 0;
        boolean flipped = false;
        if(b < 0){
            b = flip(b);
            flipped = true;
        }
        //add a for b times
        while(b > 0){
            sum += a;
            b--;
        }
        //if b si negative, return flipped result
        return flipped ? flip(sum) : sum;
    }

    public static int abs(int a){
        if(a < 0){
            return flip(a);
        }
        return a;
    }

    /*divide a and b*/
    public static int divide(int a, int b) throws Exception{
        if(b == 0){
            throw new Exception("b can not be zero");
        }
        boolean flipped = false;
        if((a > 0 && b < 0) || (a < 0 && b > 0)){
            flipped = true;
        }
        a = abs(a);
        b = abs(b);
        int res = 0;
        int temp = b;
        //count how many b in a
        while(temp <= a){
            res++;
            temp += b;
        }
        return flipped ? flip(res) : res;
    }
}
