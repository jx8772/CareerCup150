package chapter4.Question7;

/**
 * Problem: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. Node: This is not necessarily a bst
 * Created by xiangji on 8/17/14.
 */
public class Question7 {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(9);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        if (ancestor != null) {
            System.out.println(ancestor.data);
        } else {
            System.out.println("null");
        }
    }

    public static TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        //if root is equal to one of the node, the root is the common ancestor
        if(root == p || root == q){
            return root;
        }
        boolean pInLeft = coverNode(root.left, p);
        boolean qInLeft = coverNode(root.left, q);
        //if p and q are in same side, recursively search
        if(pInLeft == qInLeft){
            TreeNode child = pInLeft ? root.left : root.right;
            return helper(child, p, q);
        }
        //if p and q are not in same side, root is the common ancestor
        else{
            return root;
        }
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //error check
        if(!coverNode(root,p) || !coverNode(root,q)){
            return null;
        }
        return helper(root, p, q);
    }

    public static boolean coverNode(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        if(root == node){
            return true;
        }
        return (coverNode(root.left, node) || coverNode(root.right, node));
    }
}
