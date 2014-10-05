package chapter11;

import CtCILibrary.AssortedMethods;

/**
 * Problem: You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order without using any other array space.
 * Created by xiangji on 10/4/14.
 */
public class Question1 {
    public static void merge(int[] array1, int[] array2, int length1, int length2){
        int index1 = length1-1;
        int index2 = length2-1;
        int mergedIndex = length1+length2-1;

        //only need to make sure the index2 is > 0
        while(index2 > 0){
            if(array1[index1] >= array2[index2]){
                array1[mergedIndex] = array1[index1--];
            }
            else{
                array1[mergedIndex] = array2[index2--];
            }
            mergedIndex--;
        }
    }

    public static void main(String[] args){
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 6, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }
}
