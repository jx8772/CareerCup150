package chapter4.Question6;

/**
 * Problem: Write an algorithm to find the 'next' node (i.e. in-order traversal) of a given node in a binary search tree.
 * You may assume that each node a link to its parent
 * Created by xiangji on 8/17/14.
 */
public class Question6 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inOrderNext(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }

    public static TreeNode inOrderNext(TreeNode node){
        //if node has right subtree, return the left most node in the right subtree
        if(node.right != null){
            return findLeftMost(node.right);
        }
        //go up the tree and get the parent of node n, until n is parent's left child, return parent
        TreeNode n = node;
        TreeNode p = n.parent;
        while(p != null && n != p.left){
            n = p;
            p = p.parent;
        }
        return p;
    }

    public static TreeNode findLeftMost(TreeNode node){
        TreeNode curr = node;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}
