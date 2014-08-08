package chapter1;
import java.util.Arrays;
/**
 * Problem: Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 * Created by xiangji on 8/5/14.
 */
public class Question1 {
    public static void main(String[] args){
        String test = new String("b!#:[bd");
        System.out.println(isUniqueChars2(test));
    }

    //Method 1: Use array and assume the characters are in extended ascii code (256 characters)
    public static boolean isUniqueChars(String str){
        if(str == null || str.length() == 0 || str.length() > 256){
            return false;
        }
        boolean[] charSet = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            //auto cast the char into int (e.g. a is cast into 1)
            int val = str.charAt(i);
            //if the character has been visited before, return false
            if(charSet[val]){
                return false;
            }
            else{
                charSet[val] = true;
            }
        }
        //if all characters are visited only once, return true
        return true;
    }

    //method 2: First sort the chars in string, and check every char and its next char
    public static boolean isUniqueChars2(String str){
        if(str == null || str.length() == 0 || str.length() > 256){
            return false;
        }
        char[] chars = str.toCharArray();
        //the characters will be sorted based on their decimal value, in increasing order by default
        Arrays.sort(chars);
        for(int i = 0; i < chars.length-1; i++){
            if(chars[i] == chars[i+1]){
                return false;
            }
        }
        return true;
    }
}
