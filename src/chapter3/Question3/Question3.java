package chapter3.Question3;

/**
 * Problem: Imagine a stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and pop() should behave identically to a single stack.
 * Follow Up: Implement a function popAt(int index), which performs a pop operation on a specific sub-stack.
 * Created by xiangji on 8/11/14.
 */
public class Question3 {
    public static void main(String[] args) throws Exception{
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
//        for (int i = 0; i < 34; i++) {
//            System.out.println("Popped " + set.pop());
//        }
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(2));
        System.out.println(set.popAt(3));
        System.out.println(set.popAt(1));
        return;
    }
}
