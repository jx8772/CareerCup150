package chapter4.Question3;

/**
 * Problem: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height
 * Created by xiangji on 8/14/14.
 */
public class Question3 {
    public static void main(String[] args){
        //int[] array = {1,2,3,4,5,6,7};
        int[] array = {1,2,3,4,5,6};
        TreeNode root = createMinimalBST(array);
        return;
    }

    public static TreeNode createMinimalBST(int[] array){
        return helper(array,0,array.length-1);
    }

    private static TreeNode helper(int[] array, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode n = new TreeNode(array[mid]);
        TreeNode left = helper(array,start,mid-1);
        TreeNode right = helper(array,mid+1,end);
        n.left = left;
        n.right = right;
        return n;
    }
}
