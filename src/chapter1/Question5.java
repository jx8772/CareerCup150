package chapter1;

/**
 * Problem: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, you method should return the original string
 *
 * Created by xiangji on 8/6/14.
 */
public class Question5 {
    public static void main(String[] args){
        System.out.println(compress("aaaaca"));
    }

    public static String compress(String str){
        int size = getCompressionSize(str);
        //if the compressed string is not smaller than the original one, return the original string
        if(size >= str.length()){
            return str;
        }
        //StringBuilder is efficient for append operation
        StringBuilder sb = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }
            else{
                sb.append(last);
                sb.append(count);
                //update the last character
                last = str.charAt(i);
                //update the count of last character
                count = 1;
            }
        }
        //append the last char sequence
        sb.append(last);
        sb.append(count);
        return sb.toString();
    }

    //this function returns the size of compressed string
    private static int getCompressionSize(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char last = str.charAt(0);
        int count = 1;
        int size = 0;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }
            else{
                //String.valueOf return the string version of an int
                size += 1 + String.valueOf(count).length();
                //update the last character
                last = str.charAt(i);
                //update the count of last character
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

}
