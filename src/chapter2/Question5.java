package chapter2;
import CtCILibrary.ListNode;

/**
 * Problem: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list. Write a function that adds two numbers and returns the sum as
 * a linked list.
 * Follow up: suppose the digits are stored in forward order. Repeat the above problem.
 * Created by xiangji on 8/9/14.
 */
public class Question5 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(8);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = addLists(l1, l4, 0);
        return;
    }

    public static ListNode addLists(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        ListNode result = new ListNode();
        //add the carry to value
        int value = carry;
        //add the digit of first number to value, if any
        if(l1 != null){
            value += l1.val;
        }
        //add the digit of second number to value, if any
        if(l2 != null){
            value += l2.val;
        }
        //get the value considering carry
        result.val = value%10;
        //recursively get the result of higher digits
        if(l1 != null || l2 != null){
            ListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
}
