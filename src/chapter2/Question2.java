package chapter2;
import CtCILibrary.ListNode;

/**
 * Problem: Implement an algorithm to find the kth to last element of a singly linked list
 * Created by xiangji on 8/7/14.
 */
public class Question2 {
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
        ListNode n = kthToLast(l1,1);
    }

    //k is defined from 0, which means that if k is 0, return the last node; if k is 1, return the second to the last node
    public static ListNode kthToLast(ListNode head, int k){
        if(k < 0){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        //p2 moves k steps
        for(int i = 1; i <= k; i++){
            if(p2 == null){
                return null;
            }
            p2 = p2.next;
        }
        //move p1 and p2 at the same pace until p2 reach the end, which will take length-k-1 steps
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //p1 reach the current node with length-k-1 steps, which is the kth node from the last end
        return p1;
    }
}
