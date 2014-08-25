package chapter4.Question5;

/**
 * Problem: Implement a function to check whether a binary tree is a binary search tree
 * Created by xiangji on 8/14/14.
 */
public class Question5 {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.print(checkBST(t1));
    }

    public static boolean checkBST(TreeNode root){
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer min, Integer max){
        //base case
        if(root == null){
            return true;
        }
        //check if the current node's value is within the range
        if((min != null && root.val < min) || (max != null && root.val > max)){
            return false;
        }
        //1. update the max and recursive check left child, 2. update the min and recursively check right child
        if(!helper(root.left, min, root.val) || !helper(root.right, root.val+1, max)){
            return false;
        }
        return true;
    }

}
