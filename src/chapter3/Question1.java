package chapter3;

/**
 * Problem: Describe how you could use a single array to implement three stacks
 * Created by xiangji on 8/11/14.
 */
public class Question1 {
    private int stackSize = 5;
    private int[] buffer = new int[stackSize*100];
    //stores the relative index of stack top
    private int[] stackTopPointer = {-1,-1,-1};

    public static void main(String[] args) throws Exception{
        Question1 stack = new Question1();
        stack.push(0,2);
        System.out.println(stack.peek(0));
        stack.pop(0);
        //System.out.println(stack.peek(0));
        stack.push(1,2);
        stack.push(1,3);
        stack.push(1,4);
        stack.push(1,5);
        stack.push(1,6);
        //throws exception
        stack.pop(1);
        System.out.println(stack.peek(1));

    }

    public void push(int stackNum, int value) throws Exception{
        //check the stack is not full
        if(isFull(stackNum)){
            throw new Exception("stack is full");
        }
        //increment the corresponding stackTopPointer, and update the value
        stackTopPointer[stackNum]++;
        int index = getTopIndex(stackNum);
        buffer[index] = value;
    }

    public int pop(int stackNum) throws Exception{
        //check the stack is not empty
        if(isEmpty(stackNum)){
            throw new Exception("stack is empty");
        }
        //update the top value to be 0, and decrement the stackTopPointer
        int index = getTopIndex(stackNum);
        int top = buffer[index];
        buffer[index] = 0;
        stackTopPointer[stackNum]--;
        return top;
    }

    public int peek(int stackNum) throws Exception{
        //check the stack is not empty
        if(isEmpty(stackNum)){
            throw new Exception("stack is empty");
        }
        int index = getTopIndex(stackNum);
        return buffer[index];
    }

    public boolean isEmpty(int stackNum){
        return stackTopPointer[stackNum] == -1;
    }

    private boolean isFull(int stackNUm){
        return stackTopPointer[stackNUm] == stackSize-1;
    }

    //returns absolute index of individual stack's top in buffer
    private int getTopIndex(int stackNum){
        return stackNum*stackSize + stackTopPointer[stackNum];
    }
}
