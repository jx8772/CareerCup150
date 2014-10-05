package chapter18;
import CtCILibrary.AssortedMethods;

/**
 * Problem: You have a large text file. Given any two words, find the shortest distance(in terms of number of words)
 * between the two given words in the file. Can you make the searching operation in O(1) time? what about the space complexity for your solution?
 * Created by xiangji on 9/17/14.
 */
public class Question5 {

    /*assume that the order of the words does not matter*/
    public static int shortest(String[] words, String word1, String word2){
        if(word1.equals(word2)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int lastPosWord1 = -1;
        int lastPosWord2 = -2;

        for(int i = 0; i < words.length; i++){
            String curr = words[i];
            if(curr.equals(word1)){
                //word1 is found, record its position
                lastPosWord1 = i;
                if(lastPosWord2 >= 0){
                    //if word2 has been recorded
                    int dist = Math.abs(lastPosWord1 - lastPosWord2);  //distance is defined as number of words between the two words plus 1
                    min = dist < min ? dist : min;
                }
            }
            else if(curr.equals(word2)){
                //word2 is found, record its position
                lastPosWord2 = i;
                if(lastPosWord1 >= 0){
                    int dist = Math.abs(lastPosWord1 - lastPosWord2);
                    min = dist < min ? dist : min;
                }
            }
        }
        return min;
    }

    /*refer to CTCI source code, used for testing*/
    public static String wordAtLocation(String[] words, int loc) {
        if (loc < 0 || loc >= words.length) {
            return null;
        }
        return words[loc];
    }

    /*refer to CTCI source code, used for testing*/
    // Method to confirm other result
    public static boolean searchConfirm(String[] words, String word1, String word2, int distance) {
        boolean found_at_distance = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 1; j < distance; j++) {
                    String loc2a = wordAtLocation(words, i - j);
                    String loc2b = wordAtLocation(words, i + j);
                    if (word2.equals(loc2a) || word2.equals(loc2b)) {
                        return false;
                    }
                }

                String loc2a = wordAtLocation(words, i - distance);
                String loc2b = wordAtLocation(words, i + distance);
                if (word2.equals(loc2a) || word2.equals(loc2b)) {
                    found_at_distance = true;
                }
            }
        }
        return found_at_distance;
    }

    /*refer to CTCI source code, used for testing*/
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        System.out.println(AssortedMethods.stringArrayToString(wordlist));

        String[][] pairs = {{"Lara", "the"}, {"river", "life"}, {"path", "their"}, {"life", "a"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            int distance = shortest(wordlist, word1, word2);
            boolean confirm = searchConfirm(wordlist, word1, word2, distance);
            System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + distance + " (" + confirm + ")");
        }
    }
}
