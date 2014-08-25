package chapter4.Question4;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * Problem: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * Created by xiangji on 8/14/14.
 */
public class Question4 {
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
        ArrayList<LinkedList<TreeNode>> res = createLevelLinkedList(t1);
        return;
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
        helper(root, res, 0);
        return res;
    }

    private static void helper(TreeNode root, ArrayList<LinkedList<TreeNode>> res, int level){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> list = null;
        //the current level do not have its linked list, we create one
        if(level == res.size()){
            list = new LinkedList<TreeNode>();
            res.add(list);
        }
        //the current level already has its linked list, we use it
        else{
            list = res.get(level);
        }
        //add the current node to list
        list.add(root);
        //recursively add its left child to result
        helper(root.left, res, level+1);
        //recursively add its right child to result
        helper(root.right, res, level+1);
        return;
    }

}
