package chapter17;

/**
 * Problem: Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, the entire array would
 * be sorted. Minimize n-m (that is, find the smallest such sequence)
 * Created by xiangji on 8/25/14.
 */
public class Question6 {
    public static void main(String[] args){
        int[] a = {1,2,4,7,10,11,81, 7, 12,6,7,16,18,19};
        findMinimalUnsortedRange(a);
    }

    //method 1: this method is O(n^3) complexity
//    public static void findMinimalUnsortedRange(int[] a){
//        int len = a.length;
//        int n = 0,m = 0;
//        int minLen = Integer.MAX_VALUE;
//
//        for(int i = 0; i < len-1; i++){
//            for(int j = i+1; j < len; j++){
//                if(isMinimalUnsorted(a, i, j) && j-i+1 < minLen){
//                    n = i;
//                    m = j;
//                    minLen = j-i+1;
//                }
//            }
//        }
//        System.out.println("n is " + n);
//        System.out.println("m is " + m);
//    }
//
//    public static boolean isMinimalUnsorted(int[] a, int start, int end){
//        if(!isSorted(a, 0, start-1)){
//            return false;
//        }
//        if(!isSorted(a, end+1, a.length-1)){
//            return false;
//        }
//        int min = a[start];
//        int max = a[start];
//        for(int i = start; i <= end; i++){
//            min = a[i] < min ? a[i] : min;
//            max = a[i] > max ? a[i] : max;
//        }
//        if(start-1 >= 0 && a[start-1] > min){
//            return false;
//        }
//        if(end+1 < a.length && a[end+1] < max){
//            return false;
//        }
//        return true;
//    }
//
//    public static boolean isSorted(int[] a, int start, int end){
//        if(start >= end){
//            return true;
//        }
//        for(int i = start; i < end; i++){
//            if(a[i] > a[i+1]){
//                return false;
//            }
//        }
//        return true;
//    }

    //method 2: a better method. Time complexity is O(n)
    public static void findMinimalUnsortedRange(int[] a){
        int leftEnd = findLeftEnd(a);
        int rightStart = findRightStart(a);
        int begin = 0;
        int end = 0;

        //THIS INITIALIZATION IS CRUCIAL! otherwise, there will be problem considering input: {1,2,4,7,10,11,81, 7, 12,6,7,16,18,19};
        int min = a[rightStart];
        int max = a[leftEnd];
        //find the min and max of the middle part
        for(int i = leftEnd+1; i <= rightStart-1; i++){
            min = a[i] < min ? a[i] : min;
            max = a[i] > max ? a[i] : max;
        }

        //shrink the left part if the largest value of left part > min of middle part
        while(leftEnd >= 0 && a[leftEnd] > min){
            leftEnd--;
        }
        begin = leftEnd+1;

        //shrink the right part if the min value of right part < max of middle part
        while(rightStart <= a.length-1 && a[rightStart] < max){
            rightStart++;
        }
        end = rightStart-1;

        System.out.println("begin is " + begin);
        System.out.println("end is " + end);
    }

    public static int findLeftEnd(int[] a){
        int len = a.length;
        for(int i = 0; i < len-1; i++){
            if(a[i] > a[i+1]){
                return i;
            }
        }
        return len-1;
    }

    public static int findRightStart(int[] a){
        int len = a.length;
        for(int i = len-1; i > 0; i--){
            if(a[i] < a[i-1]){
                return i;
            }
        }
        return 0;
    }
}
