package chapter11;

import CtCILibrary.AssortedMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Problem: Write a method to sort an array of strings so that all the anagrams are next to each other.
 * Created by xiangji on 10/4/14.
 */
public class Question2 {
    public static void sortAnagrams(String[] array){
        if(array.length == 0){
            return;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        //map the sorted string to original strings with same sorted string
        for(String s : array){
            String sorted = sortChars(s);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<String>(Arrays.asList(s)));
            }
            else{
                ArrayList<String> anagrams = map.get(sorted);
                anagrams.add(s);
            }
        }

        //group the anagrams back to original array
        int index = 0;
        for(String s : map.keySet()){
            ArrayList<String> anagrams = map.get(s);
            for(String anagram : anagrams){
                array[index++] = anagram;
            }
        }
    }

    //sort the characters inside a string
    public static String sortChars(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sortAnagrams(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}
