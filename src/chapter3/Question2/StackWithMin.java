package chapter3.Question2;
import java.util.Stack;

/**
 * Created by xiangji on 8/11/14.
 */
public class StackWithMin extends Stack<NodeWithMin>{
    public void push(int value){
        int min = Math.min(value, min());
        this.push(new NodeWithMin(min, value));
    }

    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return this.peek().min;
    }
}
