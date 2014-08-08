package chapter1;

/**
 * Problem: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" length of the string
 * Created by xiangji on 8/5/14.
 */
public class Question4 {
    public static void main(String[] args){
        String s = "we are the chamption      ";
        replaceSpaces(s.toCharArray(), 20);
    }

    public static void replaceSpaces(char[] str, int length){
        int num = 0;
        //use the length instead of str.length, since there might be additional spaces in the end to hold the extended string
        for(int i = 0; i < length; i++){
            if(str[i] == ' '){
                num++;
            }
        }
        //' ' becomes '%20'
        int newLength = length+num*2;
        //modify the array from end to start. We assume that there are enough space in the end, otherwise, the original array will be overwrote
        for(int i = length-1; i >= 0; i--){
            if(str[i] == ' '){
                str[newLength-1] = '0';
                str[newLength-2] = '2';
                str[newLength-3] = '%';
                newLength -= 3;
            }
            else{
                str[newLength-1] = str[i];
                newLength--;
            }
        }
    }
}
