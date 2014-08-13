package chapter3.Question2;
import java.util.Stack;

/**
 * Created by xiangji on 8/11/14.
 */
public class StackWIthMin2 extends Stack<Integer> {
    //every time a new min is encounter, store it in stack
    public Stack<Integer> minStack;
    public StackWIthMin2(){
        minStack = new Stack<Integer>();
    }

    public void push(int value){
        if(value < min()){
            //insert the new min into stack
            minStack.push(value);
        }
        //if use this.push(value), will cause infinite loop
        super.push(value);
    }

    public Integer pop(){
        //if use this.pop, will cause infinite loop
        int value = super.pop();
        //the min number is popped
        if(value == min()){
            minStack.pop();
        }
        return value;
    }

    public int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
