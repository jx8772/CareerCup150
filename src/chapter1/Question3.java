package chapter1;

/**
 * Problem: Given two strings, write a method to decide if one is a permutation of the other
 * Created by xiangji on 8/5/14.
 */
public class Question3 {
    public static void main(String[] args){
        System.out.println(permutation("abc", "cbt"));
    }

    public static boolean permutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        //assume the characters are in ascii code, use this array to record the number of occurrences of each character
        int[] chars = new int[256];
        for(int i = 0; i < s1.length(); i++){
            int val = s1.charAt(i);
            chars[val]++;
        }
        //decrement the count by scanning the second string
        for(int i = 0; i < s2.length(); i++){
            int val = s2.charAt(i);
            chars[val]--;
        }
        //check if counts are all 0
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != 0){
                return false;
            }
        }
        return true;
    }
}
