package chapter2;
import CtCILibrary.ListNode;

/**
 * Problem: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
 * Created by xiangji on 8/8/14.
 */
public class Question4 {
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
        partition(l1,1);
    }

    public static ListNode partition(ListNode node, int x){
        ListNode beforeStart = null;
        ListNode afterStart = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            if(curr.val < x){
                //append the current node to the front of beforeStart
                curr.next = beforeStart;
                //update the beforeStart to be the head node
                beforeStart = curr;
            }
            else{
                //append the current node to the front of afterStart
                curr.next = afterStart;
                afterStart = curr;
            }
            curr = next;
        }
        //if the before linkedlist is empty, return the head of after linkedlist
        if(beforeStart == null){
            return afterStart;
        }
        //merge the two linkedlists
        ListNode head = beforeStart;
        //find the end of before linkedlist
        while(beforeStart.next != null){
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;
        return head;
    }
}

