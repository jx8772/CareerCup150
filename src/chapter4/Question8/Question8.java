package chapter4.Question8;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

/**
 * Problem: You have two large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * Created by xiangji on 8/18/14.
 */
public class Question8 {
    public static void main(String[] args) {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};

        TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

        if (treeContain(t1, t2))
            System.out.println("t2 is a subtree of t1");
        else
            System.out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

        if (treeContain(t3, t4))
            System.out.println("t4 is a subtree of t3");
        else
            System.out.println("t4 is not a subtree of t3");
    }

    public static boolean treeContain(TreeNode t1, TreeNode t2){
        //if t2 is empty, t1 always contains empty tree
        if(t2 == null){
            return true;
        }
        return subTree(t1,t2);
    }

    public static boolean subTree(TreeNode t1, TreeNode t2){
        //if t1 is empty, it can not contain any tree
        if(t1 == null){
            return false;
        }
        if(t1.data == t2.data){
            if(treeIdentical(t1,t2)){
                return true;
            }
        }
        return (subTree(t1.left, t2) || subTree(t1.right, t2));
    }

    public static boolean treeIdentical(TreeNode t1, TreeNode t2){
        //if both nodes are null, return true
        if(t1 == null && t2 == null){
            return true;
        }
        //if only one of the two nodes is not null, return false
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.data != t2.data){
            return false;
        }
        else{
            //if the two subtrees are both identical, return true
            return treeIdentical(t1.left, t2.left) && treeIdentical(t1.right,t2.right);
        }
    }
}
