package chapter9;

//cc150 Q9.3 magic index
public class Question3_1 {
    public static void main(String[] args){
        int[] test = {-40,-20,-1,1,2,3,5,7,9,12,13};
        System.out.println(magicIndex(test));
    }

    public static int magicIndex(int[] N){
        if(N.length == 0){
            return -1;
        }
        int l = 0;
        int r = N.length;
        while(l<=r) {
            int mid = (l+r)/2;
            if(N[mid] == mid){
                return mid;
            }
            else if(N[mid] < mid){
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return -1;
    }
}
