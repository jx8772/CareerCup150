package chapter11;

/**
 * Problem: Given a sorted array of n integers that has been rotated a number of times, write code to find an element in the array. You may assume that the array was originally sorted in incresing order.
 * Created by xiangji on 10/4/14.
 */
public class Question3 {
    public static boolean search(int[] A, int target){
        if(A.length == 0){
            return false;
        }
        int l = 0;
        int r = A.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(A[mid] == target){
                return true;
            }
            //left part is sorted
            if(A[mid] > A[l]){
                //if target is in left part
                if(target >= A[l] && target < A[mid]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            //right part is sorted
            else if(A[mid] < A[l]){
                //if target is in right part
                if(target <= A[r] && target > A[mid]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            //if A[mid] == A[l]
            else{
                //if A[mid] == A[r], can not decide which part
                if(A[mid] == A[r]){
                    for(int i = l; i <= r; i++){
                        if(A[i] == target){
                            return true;
                        }
                    }
                }
                //left part is flat, right part is hill. target is in the right part
                else{
                    l = mid+1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {3, 3, 3, 3, 3, 4, 5, 6, 2};
        boolean found = search(array, 5);
    }
}
