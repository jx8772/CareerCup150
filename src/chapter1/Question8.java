package chapter1;

/**
 * Problem: Assume we have a method isSubString which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation
 * of s1 using only one call to isSubString (e.g. "waterbottle" is a rotation of "erbottlewat")
 * Created by xiangji on 8/7/14.
 */
public class Question8 {
    public static void main(String[] args){
        String s1 = "waterbottle";
        String s2 = "erbottlewa";
        System.out.println(isRotation(s1,s2));
    }

    //check whether s2 is a roration of s1
    public static boolean isRotation(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == len2){
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        else{
            return false;
        }
    }

    //this function checks if s2 is a substring of s1
    private static boolean isSubString(String s1, String s2){
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() < s2.length()){
            return false;
        }
        return s1.contains(s2);
    }
}
