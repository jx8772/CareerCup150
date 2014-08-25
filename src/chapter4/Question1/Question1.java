package chapter4.Question1;
import CtCILibrary.TreeNode;

/**
 * Problem: Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such
 * that the heights of the two subtrees of any node never differ by more than one.
 * Created by xiangji on 8/13/14.
 */
public class Question1 {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t6.left = t7;
        System.out.println(isBalanced(t1));
    }

    public static boolean isBalanced(TreeNode t){
        if(checkHeight(t) == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public static int checkHeight(TreeNode t){
        if(t == null){
            return 0;
        }
        //check left tree, if the left subtree is not balanced, return -1
        int leftHeight = checkHeight(t.left);
        if(leftHeight == -1){
            return -1;
        }
        //check right tree
        int rightHeight = checkHeight(t.right);
        if(rightHeight == -1){
            return -1;
        }
        //check whether it is balanced
        int diff = Math.abs(leftHeight-rightHeight);
        //not balance
        if(diff > 1){
            return -1;
        }
        //if balanced, return the height
        else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
