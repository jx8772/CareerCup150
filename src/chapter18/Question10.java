package chapter18;
import java.util.*;

/**
 * Problem: Given two words of equal length that are in a dictionary, write a method to transform one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in the dictionary
 * Created by xiangji on 9/18/14.
 */
public class Question10 {
    public static HashSet<String> setupDictionary(String[] words) {
        HashSet<String> hash = new HashSet<String>();
        for (String word : words) {
            hash.add(word.toLowerCase());
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "free", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
        HashSet<String> dict = setupDictionary(words);
        LinkedList<String> list = bfs("tree", "flat", dict);
        for (String word : list) {
            System.out.println(word);
        }
    }

    public static LinkedList<String> bfs(String start, String end, Set<String> dict){
        //this is the queue for bfs
        Queue<String> queue = new LinkedList<String>();
        //record the visited node
        Set<String> visited = new TreeSet<String>();
        //record the distance of a node to the starting node
        HashMap<String, Integer> distanceToStart = new HashMap<String, Integer>();
        //map a child to its parent
        HashMap<String, String> parentMap = new HashMap<String, String>();

        start = start.toLowerCase();
        end = end.toLowerCase();
        queue.offer(start);
        visited.add(start);
        distanceToStart.put(start,0);
        parentMap.put(start, null);

        while(!queue.isEmpty()){
            String curr = queue.poll();
            for(String neighbor : getOneEditWords(curr)){
                if(neighbor.equals(end)){
                    //a path is found
                    distanceToStart.put(neighbor, distanceToStart.get(curr)+1);
                    LinkedList<String> res = new LinkedList<String>();
                    res.add(0,end);
                    while(curr != null){
                        res.add(0, curr);
                        curr = parentMap.get(curr);
                    }
                    return res;
                }
                if(dict.contains(neighbor) && !visited.contains(neighbor)){
                    visited.add(neighbor);
                    distanceToStart.put(neighbor, distanceToStart.get(curr)+1);
                    parentMap.put(neighbor, curr); //map from child to parent
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }

    /*get the set of words which are only one character away from word*/
    public static Set<String> getOneEditWords(String word){
        Set<String> set = new TreeSet<String>();
        for(int i = 0; i < word.length(); i++){
            char[] wordArray = word.toCharArray();
            for(char c = 'a'; c <= 'z'; c++){
                if(c != wordArray[i]){
                    wordArray[i] = c;
                    set.add(new String(wordArray));
                }
            }
        }
        return set;
    }

}
