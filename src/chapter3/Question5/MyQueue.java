package chapter3.Question5;
import java.util.Stack;

/**
 * Created by xiangji on 8/12/14.
 */
public class MyQueue {
    Stack<Integer> newStack, oldStack;

    public MyQueue(){
        newStack = new Stack<Integer>();
        oldStack = new Stack<Integer>();
    }

    public int size(){
        return newStack.size() + oldStack.size();
    }

    public void add(int value){
        //always push to the newStack
        newStack.push(value);
    }

    //move the elements from new to old stack in reverse order
    private void shiftStacks(){
        if(oldStack.isEmpty()){
            while(!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }

    public int peek(){
        if(this.size() == 0){
            System.out.println("error: the stack is empty");
        }
        //we make sure the oldStack has the element
        shiftStacks();
        return oldStack.peek();
    }

    public int remove(){
        if(this.size() == 0){
            System.out.println("error: the stack is empty");
        }
        //make sure the oldStack has the element
        shiftStacks();
        return oldStack.pop();
    }
}
