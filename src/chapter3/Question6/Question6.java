package chapter3.Question6;
import java.util.Stack;
/**
 * Problem: Write a program to sort a stack in ascending order (with biggest item on top). You may use at most one additional stack to hold items, but you
 * may not copy the elements into any other data structures (such as array). The stack supports the following operations: push, pop, peek, and isEmpty
 * Created by xiangji on 8/12/14.
 */
public class Question6 {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(5);
        s.push(2);
        s.push(9);
        s.push(8);
        Stack<Integer> res = sort(s);
        return;
    }

    public static Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> res = new Stack<Integer>();
        while(!s.isEmpty()){
            int top = s.pop();
            //if the top value in res is greater than the current value, push it back to original stack
            while(!res.isEmpty() && res.peek() > top){
                s.push(res.pop());
            }
            //push the current value to result stack
            res.push(top);
        }
        return res;
    }
}
