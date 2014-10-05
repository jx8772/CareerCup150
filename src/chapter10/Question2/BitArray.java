package chapter10.Question2;

/**
 * Created by xiangji on 10/3/14.
 */
/*
* The class enables using N-bit space to represent N bit
* */
public class BitArray {
    int[] bitset;

    BitArray(int size){
        bitset = new int[size/32]; //use the one integer to represent 8 bits
    }

    public boolean get(int pos){
        int wordNumber = pos/32; //get the right integer
        int mask = 1 << pos%32;
        return ((bitset[wordNumber] & mask) != 0);
    }

    public void set(int pos){
        int wordNumber = pos/32;
        int mask = 1 << pos%32;
        bitset[wordNumber] |= mask;
    }
}
