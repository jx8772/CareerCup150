package chapter10.Question2;
import CtCILibrary.AssortedMethods;

/**
 * Created by xiangji on 10/3/14.
 */
public class Question4 {
    public static void printDuplicate(int[] array){
        BitArray ba = new BitArray(32000);

        for(int i = 0; i < array.length; i++){
            int bitIndex = array[i]-1;
            if(ba.get(bitIndex)){
                System.out.println(bitIndex+1);
            }
            else{
                ba.set(bitIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(30, 1, 30);
        System.out.println(AssortedMethods.arrayToString(array));
        printDuplicate(array);
    }
}
