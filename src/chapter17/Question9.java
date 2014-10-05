package chapter17;
import java.util.HashMap;

/**
 * Problem: Design a method to find the frequency of occurrences of any given word in a book
 * Created by xiangji on 9/11/14.
 */
public class Question9 {
    /*we assume that the book is an array of words, and the punctuations are already thrown away*/
    public static void main(String[] args){
        String test[] = {"I", "found", "a", "cat", "in", "a", "house", "but", "the", "house", "is", "full", "of", "dogs"};
        HashMap<String, Integer> map = createDict(test);
        //test a word appearing 1 time
        System.out.println(getFrequency(map, "cat"));
        //test a word appearing 2 times
        System.out.println(getFrequency(map, "house"));
        //test an empty word
        System.out.println(getFrequency(map, ""));
        //test an word appearing 0 time
        System.out.println(getFrequency(map, "tiger"));
        //test an upper case word
        System.out.println(getFrequency(map, "A"));
    }

    /*create a dict to store the words' frequency*/
    public static HashMap<String, Integer> createDict(String[] book){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if(book == null){
            return map;
        }
        for(String s : book){
            //convert the string to lower case for easy query
            s = s.toLowerCase();
            if(!s.equals("")){
                //if word is already in dict, increment the count
                if(map.containsKey(s)){
                    map.put(s, map.get(s)+1);
                }
                //if word is not in dict, put it
                else{
                    map.put(s, 1);
                }
            }
        }
        return map;
    }

    /*get the frequency of a word*/
    public static int getFrequency(HashMap<String, Integer> map, String word){
        if(map == null || word == null){
            return -1;
        }
        word = word.toLowerCase();
        if(map.containsKey(word)){
            return map.get(word);
        }
        else{
            return 0;
        }
    }
}
