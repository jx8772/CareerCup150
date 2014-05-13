package chapter5;

public class Question5 {
    public static void main(String[] args){
        System.out.println(getNumFlips(125,45));
    }

    public static int getNumFlips(int i, int j){
        int xor = i ^ j;
        int count = 0;
        for(int digit = 0; digit <= 31; digit++){
            //check the "digit"th bit, if the bit is 1, increment the counter
            if(((1 << digit) & xor) != 0){
                count++;
            }
        }
        return count;
    }
}
