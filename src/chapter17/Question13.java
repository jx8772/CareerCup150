package chapter17;

/**
 * Problem: Consider a simple node-like data structure called BiNode, which has pointers to two
 other nodes. The data structure BiNode could be used to represent both  a binary
 tree (where nodel is the left node and node2 is the right  node) or a doubly  linked
 list (where nodel  is the previous node and node2 is the next node). Implement  a
 method to convert a binary  search tree (implemented  with BiNode) into a doubly
 linked list. The values should be kept in order and the operation should be performed
 in place (that is, on the original  data structure).
 * Created by xiangji on 9/11/14.
 */
public class Question13 {
    public static void main(String[] args){
        BiNode root = createTree();
        BiNode n = convert(root);
        return;
    }

    /*for testing purpose*/
    public static BiNode createTree(){
        BiNode[] nodes = new BiNode[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new BiNode(i);
        }
        nodes[4].node1 = nodes[2];
        nodes[4].node2 = nodes[5];
        nodes[2].node1 = nodes[1];
        nodes[2].node2 = nodes[3];
        nodes[5].node2 = nodes[6];
        nodes[1].node1 = nodes[0];
        return nodes[4];
    }

    //convert the tree-like BiNode into a doublely linked list Binode
    public static BiNode convert(BiNode root){
        if(root == null){
            return null;
        }
        //recursively process left subtree
        BiNode left = convert(root.node1);
        //recursively process right subtree
        BiNode right = convert(root.node2);
        if(left != null){
            concatenate(getTail(left), root);
        }
        if(right != null){
            concatenate(root, right);
        }
        if(left == null){
            return root;
        }
        else{
            return left;
        }
    }

    /*return the tail node of a doublely linekd list*/
    public static BiNode getTail(BiNode head){
        BiNode curr = head;
        while(curr.node2 != null){
            curr = curr.node2;
        }
        return curr;
    }

    /*concatenate two nodes*/
    public static void concatenate(BiNode n1, BiNode n2){
        n1.node2 = n2;
        n2.node1 = n1;
    }
}
