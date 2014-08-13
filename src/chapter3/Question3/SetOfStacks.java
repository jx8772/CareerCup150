package chapter3.Question3;
import java.util.ArrayList;

/**
 * Created by xiangji on 8/11/14.
 */
public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    //capacity is the capacity for each stack in the set
    int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public void push(int value){
        Stack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(value);
        }
        else{
            Stack s = new Stack(capacity);
            s.push(value);
            stacks.add(s);
        }
    }

    public int pop() throws Exception{
        Stack last = getLastStack();
        if(last == null){
            throw new Exception("stack is empty");
        }
        int v = last.pop();
        if(last.size == 0){
            stacks.remove(stacks.size()-1);
        }
        return v;
    }

    public int popAt(int index){
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop){
        Stack stack = stacks.get(index);
        int removed_item;
        //if it is the first stack, we just remove the top value
        if(removeTop){
            removed_item = stack.pop();
        }
        //if it is not the first stack, we roll over the stacks after
        else{
            removed_item = stack.removeBottom();
        }
        //if the stack is empty, we delete this stack and do not left shift anymore
        if(stack.isEmpty()){
            stacks.remove(index);
        }
        //otherwise, recursively left shift the next stack
        else if(index+1 < stacks.size()){
            leftShift(index+1, false);
        }
        return removed_item;
    }

    public Stack getLastStack(){
        if(stacks.size() == 0){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }
}
