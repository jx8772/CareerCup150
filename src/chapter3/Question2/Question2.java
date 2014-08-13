package chapter3.Question2;

/**
 * Problem: How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? push, pop and min should all
 * operate in O(1) time
 * Created by xiangji on 8/11/14.
 */
public class Question2 {
    public static void main(String[] args){
        StackWIthMin2 stack = new StackWIthMin2();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(7);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
