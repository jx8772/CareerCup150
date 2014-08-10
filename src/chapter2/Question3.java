package chapter2;
import CtCILibrary.ListNode;
/**
 * Problem: Implement an algorithm to delete a node in the middle of a singly linked list. given only access to that node
 * Example:
 * input: the node c from linked list a->b->c-d->e
 * output nothing is returned, but the new linked list looks like a-b->d->e
 * Created by xiangji on 8/8/14.
 */
public class Question3 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        deleteNode(l3);
        return;
    }

    public static boolean deleteNode(ListNode n){
        if(n == null || n.next == null){
            return false;
        }
        //copy the next node's value and next pointer to the current node
        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }

}
