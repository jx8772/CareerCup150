package chapter2;
import CtCILibrary.ListNode;
import java.util.HashMap;

/**
 * Problem: Write code to remove duplicates from an unsorted linked list.
 * Follow up: How would you solve this problem if a temporary buffer is not allowed?
 * Created by xiangji on 8/7/14.
 */
public class Question1 {
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
        deleteDuplicates2(l1);
        return;
    }

    //method 1: use hashtable, time complexity is O(n)
    public static void deleteDuplicates1(ListNode head){
        if(head == null){
            return;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            if(!map.containsKey(curr.val)){
                map.put(curr.val,true);
                //prev needs to be updated
                prev = curr;
            }
            else{
                //prev do not need to be updated
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }

    //method 2: use a probe pointer, time complexity is O(n^2)
    public static void deleteDuplicates2(ListNode head){
        if(head == null){
            return;
        }
        ListNode curr = head;
        while(curr != null){
            ListNode probe = curr;
            while(probe.next != null){
                if(probe.next.val == curr.val){
                    probe.next = probe.next.next;
                }
                else{
                    probe = probe.next;
                }
            }
            curr = curr.next;
        }
    }
}
