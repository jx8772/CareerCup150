package chapter17;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
/**
 * Created by xiangji on 9/14/14.
 */
//not completed
public class Question14 {
    public static int min = Integer.MAX_VALUE;
    public static int numSeq = 0;
    public static ArrayList<String> arrayDict = new ArrayList<String>(Arrays.asList("looked", "like", "just", "her", "brother"));

    public static void main(String[] args){

        Set<String> dict = new TreeSet<String>();
        dict.addAll(arrayDict);
        String s = "jesslookedjustliketimherbrother";
        parse(s, 0, dict);
        System.out.println(min);
    }

    public static void parse(String s, int start, Set<String> dict){
        if(start >= s.length()){
            if(numSeq < min){
                min = numSeq;
            }
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            String word = s.substring(start,i);
            if(!dict.contains(word)) {
                numSeq++;
            }
            numSeq--;
            parse(s, i, dict);
        }
        return;
    }
}
