package chapter5;

public class Question6 {
    public static void main(String[] args){
        int test = 4821;
        System.out.println(swapBits(test));
    }

    //method 2
    public static int swapBits(int num){
        int evenMask = 0x55555555;
        int oddMask = 0xAAAAAAAA;
        return ((num & evenMask) << 1) | ((num & oddMask) >> 1);
    }
}
//    public static int swapBits(int num){
//        for(int i = 0; i <= 31; i = i+2){
//            //if the bit in position i and in position i+1 are different
//            if((((1 << i) & num) != 0) != (((1 << (i+1)) & num) != 0)) {
//                //negate bit in position i
//                num = ((1 << i) ^ num);
//                //negate bit in position i+1
//                num = ((1 << i+1) ^ num);
//            }
//        }
//        return num;
//    }
 //}
