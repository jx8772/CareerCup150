package chapter17;
import java.util.HashMap;

/**
 * Problem: he Game of Master Mind is played as follows:
 The computer has four slots containing balls that are red (R), yellow (Y), green (G) or blue (B). For example, the computer might have RGGB (e.g., Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
 You, the user, are trying to guess the solution You might, for example, guess YRGB.
 When you guess the correct color for the correct slot, you get a “hit” If you guess a color that exists but is in the wrong slot, you get a “pseudo-hit”. For example, the guess YRGB has 2 hits and one pseudo hit.
 For each guess, you are told the number of hits and pseudo-hits.
 Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
 * Created by xiangji on 8/25/14.
 */
public class Question5 {
    public static int MAX_COLORS = 4;

    public static void main(String[] args) throws Exception{
        char[] guess = {'Y','R','G','B'};
        char[] solution = {'R','G','G','B'};
        Result res = countHits(guess, solution);
        System.out.println("number of hits: " + res.realHits);
        System.out.println("number of pseudo hits: " + res.pseudoHits);
    }

    private static int code(char c){
        switch (c){
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'G':
                return 2;
            case 'B':
                return 3;
            default:
                return -1;
        }
    }

    public static Result countHits(char[] guess, char[] solution) throws Exception{
        if(guess.length != MAX_COLORS || solution.length != MAX_COLORS){
            throw new Exception("input has error");
        }
        int[] frequencyTable = new int[MAX_COLORS];
        Result res = new Result();
        //count hits
        for(int i = 0; i < MAX_COLORS; i++){
            if(guess[i] == solution[i]){
                res.realHits++;
            }
            else{
                int code = code(solution[i]);
                if(code >= 0){
                    frequencyTable[code]++;
                }
            }
        }
        //count pseudo hits
        for(int i = 0; i < MAX_COLORS; i++){
            //if the char is not a previous hit or previous pseudo hit
            int code = code(guess[i]);
            if(code >= 0 && guess[i] != solution[i] && frequencyTable[code] > 0){
                res.pseudoHits++;
                frequencyTable[code]--;
            }
        }
        return res;

    }
}
