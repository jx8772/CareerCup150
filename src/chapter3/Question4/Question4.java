package chapter3.Question4;

/**
 * Problem: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with
 * disks sorted in ascending order of size from top to bottom. Write a program to move the disks from the first tower to the last using stacks
 * Created by xiangji on 8/12/14.
 */
public class Question4 {
    public static void main(String[] args){
        //number of disks
        int n = 5;
        //number of towers
        int num = 3;
        Tower[] towers = new Tower[num];

        for (int i = 0; i < num; i++){
            towers[i] = new Tower(i);
        }
        for(int i = n-1; i >= 0; i--){
            towers[0].add(i);
        }
        //move n disks to towers[2] using towers[1] as buffer
        towers[0].moveDisks(n, towers[2], towers[1]);
        return;
    }

}
