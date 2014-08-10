package chapter2;

import CtCILibrary.ListNode;

/**
 * Problem: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list. Write a function that adds two numbers and returns the sum as
 * a linked list.
 * Follow up: suppose the digits are stored in forward order. Repeat the above problem.
 * Created by xiangji on 8/9/14.
 */
public class Question5FollowUp {
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
        ListNode res = addListsFollowUp(l1, l4, 0);
        return;
    }

    public static ListNode addListsFollowUp(ListNode l1, ListNode l2, int carry){
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        if(len1 < len2){
            l1 = padList(l1,len2-len1);
        }
        else{
            l2 = padList(l2,len1-len2);
        }
        ParitialSum sum = getPartialSum(l1,l2);
        if(sum.carry == 0){
            return sum.sum;
        }
        else{
            ListNode res = insertBefore(sum.sum, 1);
            return res;
        }
    }

    //get the partial sum of two numbers represented by l1 and l2
    private static ParitialSum getPartialSum(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return new ParitialSum();
        }
        ParitialSum sum = getPartialSum(l1.next, l2.next);
        int value = sum.carry + l1.val + l2.val;
        ListNode res = insertBefore(sum.sum, value%10);
        sum.sum = res;
        sum.carry = value >= 10 ? 1 : 0;
        return sum;
    }

    //pad the list with zeros in the front
    private static ListNode padList(ListNode l, int count){
        ListNode head = l;
        for(int i = 1; i <= count; i++){
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;
        }
        return head;
    }

    //insert the data in front of a linked list
    private static ListNode insertBefore(ListNode l, int data){
        ListNode node = new ListNode(data);
        node.next = l;
        return node;
    }

    //get the length of a linked list
    private static int getLength(ListNode l){
        int count = 0;
        ListNode curr = l;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
