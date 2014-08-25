package chapter4.Question9;
import java.util.ArrayList;
/**
 * Problem: You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value.
 * The path do not need to start or end at root or leaf.
 * Created by xiangji on 8/18/14.
 */
public class Question8 {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(-1);
        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t6.left = t8;
        t8.right = t9;
        findSum(t1, 9);
    }

    public static void findSum(TreeNode root, int sum){
        if(root == null){
            return;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(root, path, sum);
    }

    private static void helper(TreeNode root, ArrayList<Integer> p, int t){
        //base case
        if(root == null){
            return;
        }
        ArrayList<Integer> path = new ArrayList<Integer>(p);
        path.add(root.val);
        int sum = 0;
        //from the root node climbing up the tree, to find a path with sum equals to t
        for(int i = path.size()-1; i >= 0; i--){
            sum += path.get(i);
            if(sum == t){
                printPath(path, i);
            }
        }
        //recursively deal with left child
        helper(root.left, path, t);
        //recursively deal with right child
        helper(root.right, path, t);
    }

    private static void printPath(ArrayList<Integer> path, int start){
        for(int i = start; i < path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

}
