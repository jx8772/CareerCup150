package chapter2;
import CtCILibrary.ListNode;
import java.util.Stack;

/**
 * Problem: Implement a function to check if a linked list is a palindrome
 * Created by xiangji on 8/9/14.
 */
public class Question7 {
    public static void main(String[] args){
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(0);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        boolean res = isPalindrome(l0);
        return;
    }

    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //when length is odd, we skip the middle node
        if(fast != null){
            slow = slow.next;
        }
        //compare the values in stacks (first half) with the values in rest of linked list (second half)
        while(slow != null){
            int top = stack.pop();
            if(top != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

}
