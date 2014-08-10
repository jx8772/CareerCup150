package chapter2;
import CtCILibrary.ListNode;

/**
 * Problem: Given a circular linked list, implement an algorithm which returns the node at the begining of the loop
 * Created by xiangji on 8/9/14.
 */
public class Question6 {
    public static void main(String[] args){
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l5;
        ListNode res = findBegining(l0);
        return;
    }

    public static ListNode findBegining(ListNode l){
        ListNode p1 = l;
        ListNode p2 = l;
        //use p1 as slow pointer, p2 as fast pointer, move both until they collide
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        //p1 and p2 are both slow pointer, move both until they collide
        p1 = l;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        //the collided position is the beginning of loop
        return p1;
    }
}
