package chapter5;

public class Question1 {
    public static void main(String[] args) {
        int M = 19, N = 1024, i = 2, j = 6;
        System.out.println(twoNumberInsert(M,N,i,j));
    }

    public static int twoNumberInsert(int M, int N, int i, int j){
        int mask_1 = ~((1 << (j+1)) -1);
        int mask_2 = ((1 << i) -1);
        int mask =  mask_1 | mask_2;
        int result_1 = (mask & N);
        int result_2 = M << i;
        return result_1 | result_2;
    }
}
