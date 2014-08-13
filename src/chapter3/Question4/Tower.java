package chapter3.Question4;
import java.util.Stack;

/**
 * Created by xiangji on 8/12/14.
 */
public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int i){
        disks = new Stack<Integer>();
        index = i;
    }

    public int index(){
        return index;
    }

    //add a new disk to this tower
    public void add(int d){
        if(!disks.isEmpty() && disks.peek() <= d){
            System.out.println("error putting disk");
        }
        disks.push(d);
    }

    //move the top disk to tower t
    public void moveTopTo(Tower t){
        int disk = disks.pop();
        t.add(disk);
    }

    //move the top n disks from this tower to destination using buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n > 0){
            //step1: move top n-1 disks from this tower to the buffer tower
            moveDisks(n-1, buffer, destination);
            //step2: move the top disk to destination tower
            moveTopTo(destination);
            //step3: move the top n-1 disks from buffer tower to destination tower
            buffer.moveDisks(n-1, destination, this);
        }
    }
}
