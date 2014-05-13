package chapter9;

//cc150 Q9.3 follow-up question of magic index
public class Question3_2 {
    public static void main(String[] args){
        int[] test = {-10,-5,1,2,2,3,4,8,9,12,13};
        System.out.print(magicIndex(test));
    }

    public static int magicIndex(int[] N){
        return binarySearch(N, 0, N.length-1);
    }

    public static int binarySearch(int[] N, int l, int r){
        if(l > r || l < 0 || r >= N.length){
            return -1;
        }
        int mid = (l+r)/2;
        int midValue = N[mid];
        if(midValue == mid){
            return mid;
        }
        //search left part, we only need to search index from 0 to midValue, since k != N[k] if index k > midValue
        int leftIndex = Math.min(mid-1,midValue);
        int left = binarySearch(N, l, leftIndex);
        if(left >= 0){
            return left;
        }
        //search right part, we only need to search index from midValue to end, since k != N[k] if index k < midValue
        int rightIndex = Math.max(mid+1, midValue);
        int right = binarySearch(N, rightIndex, r);
        if(right >= 0){
            return right;
        }
        return -1;
    }
}
