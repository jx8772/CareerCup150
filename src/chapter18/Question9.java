package chapter18;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Problem: Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated
 * Created by xiangji on 9/17/14.
 */
public class Question9 {
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void addRandomNumber(int randomNumber){
        if(maxHeap.size() == minHeap.size()){
            if(minHeap.size() > 0 && randomNumber > minHeap.peek()){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            }
            else{
                maxHeap.offer(randomNumber);
            }
        }
        else{
            if(randomNumber < maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            }
            else{
                minHeap.offer(randomNumber);
            }
        }
    }

    public static double getMedian(){
        if(maxHeap.size() == 0){
            return 0;
        }
        if(maxHeap.size() == minHeap.size()){
            return (double)((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args){
        Comparator<Integer> maxHeapComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 < o2){
                    return 1;
                }
                else if(o1 > o2){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        };

        Comparator<Integer> minHeapComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 > o2){
                    return 1;
                }
                else if(o1 < o2){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        };

        int arraySize = 15;
        int index = 12;
        minHeap = new PriorityQueue<Integer>(arraySize - arraySize/2, minHeapComparator);
        maxHeap = new PriorityQueue<Integer>(arraySize/2, maxHeapComparator);

        int[] test = {4,5,6,4,3,2,3,6,7,8,9,10,5};
        for(int i = 0; i < index; i++){
            addRandomNumber(test[i]);
            System.out.println("index: " + i + " median is " + getMedian());
        }
    }
}
