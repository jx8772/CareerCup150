package chapter17;

/**
 * Problem: Given any integer, print an English phrase that describes the integer (e.g. "One Thousand, Two Hundred Thirty Four")
 * Created by xiangji on 9/10/14.
 */
public class Question7 {
    public static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] commas = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args){
        int test1 = 234;
        int test2 = 1234;
        int test3 = -567;
        int test4 = 4564564;
        int test5 = 0;
        int test6 = -4567652;
        int test7 = Integer.MAX_VALUE;
        System.out.println(test7);
        System.out.println(describeInteger(test7));

    }

    public static String describeInteger(int i){
        if(i > Integer.MAX_VALUE || i < Integer.MIN_VALUE){
            return "Out of Range";
        }
        if(i < 0){
            return "Negative " + describeInteger(-1*i);
        }
        if(i == 0){
            return "Zero";
        }

        String res = "";
        int count = 0;
        while(i > 0){
            res = describeHundred(i%1000) + commas[count] + " " + res;
            count++;
            i /= 1000;
        }
        return res;
    }

    public static String describeHundred(int i){
        String res = "";

        /*describe hundred*/
        if(i >= 100){
            res += ones[i/100] + " Hundred ";
            i %= 100;
        }

        /*describe tens*/
        if(i >= 11 && i <= 19){
            return res + teens[i-11] + " ";
        }
        else if(i == 10 || i >= 20){
            res += tens[i/10] + " ";
            i %= 10;
        }

        /*describe ones*/
        res = res + ones[i] + " ";

        return res;
    }



}
