package chapter9;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: You have a stack of n boxes, with width w(i), depth d(i), and height h(i).
 * The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth.
 * Implement a method to build the tallest stack possible, where the height of a stack is the sum of the heights of each box.
 * Created by xiangji on 9/30/14.
 */
public class Question10 {
    public static void main(String[] args){
        Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3), new Box(5,6,8), new Box(4,12,32), new Box(1,2,3), new Box(4,5,6)};
        int max = maxHeightStack(boxes);
        return;
    }

    public static int maxHeightStack(Box[] boxes){
        Comparator<Box> minBoxComparator = new Comparator<Box>(){
            @Override
            public int compare(Box b1, Box b2){
                if(b1.height > b2.height){
                    return 1;
                }
                else if(b1.height < b2.height){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        };

        Arrays.sort(boxes, minBoxComparator);
        int max = maxHeightStackR(boxes,boxes.length);
        return max;
    }

    public static int maxHeightStackR(Box[] boxes, int bottomIndex){
        Box bottom = null;
        //if this is the first round, 0 is used as default
        int bottomHeight = 0;
        int maxHeight = 0;
        //if this is not the first round, the bottom height of the height of current bottom
        if(bottomIndex < boxes.length){
            bottom = boxes[bottomIndex];
            bottomHeight = bottom.height;
        }
        //scan all boxes with height <= bottom, find the max height
        for(int i = 0; i < bottomIndex; i++){
            Box curr = boxes[i];
            if(curr.canBeAbove(bottom)){
                int height = maxHeightStackR(boxes,i);
                maxHeight = height > maxHeight ? height : maxHeight;
            }
        }
        return bottomHeight + maxHeight;
    }
}
