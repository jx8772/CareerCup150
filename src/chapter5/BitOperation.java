package chapter5;

public class BitOperation {
    public static void main(String[] args){
        int test = 23;
        System.out.print(updateBit(test,0, 0)+ " ");
    }

    public static boolean getBit(int num, int i) {
        return (((1 << i) & num) != 0);
    }

    public static int setBit(int num, int i){
        return (num | (1 << i));
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int clearBitsMSthroughI(int num, int i){
        int mask = ((1 << i) - 1);
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int i){
        int mask = ~(-1 >>> (31-i));
        return num & mask;
    }

    public static int updateBit(int num, int i, int v){
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }
}
