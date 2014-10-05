package chapter18;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

/**
 * Problem: Given a list of words, write a program to find the longest word made of other words in the list
 * Created by xiangji on 9/17/14.
 */
public class Question7 {
    public static void main(String[] args){
        String[] strs  ={"cat", "banana", "dog", "nana", "walk", "walker",
                "dogwalker","s", "catswalker","bigdogwalker","big","catanddog","and","bigcatbananadogmouse"};
        System.out.println(getLongestString(strs));
    }

    public static String getLongestString(String[] list){
        //comparator for longest to shortest sorting
        Comparator<String> lengthComparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() < b.length()){
                    return 1;
                }
                else if(a.length() > b.length()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        };

        Arrays.sort(list, lengthComparator);
        //storing all words for easy access
        Set<String> set = new HashSet<String>();
        for(String word : list){
            set.add(word);
        }

        for(int i = 0; i < list.length; i++){
            String word = list[i];
            if(canSplit(word, true, set)){
                return word;
            }
        }
        return "";
    }

    /*check if the word can be composed by the words in the dictionary*/
    public static boolean canSplit(String word, boolean isOriginal, Set<String> set){
        if(set.contains(word) && !isOriginal){
            return true;
        }
        for(int j = 1; j < word.length(); j++){
            String part1 = word.substring(0,j);
            String part2 = word.substring(j);
            if(set.contains(part1) && canSplit(part2, false, set)){
                return true;
            }
        }
        return false;
    }


}
