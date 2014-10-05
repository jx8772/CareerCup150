package Codility.Question1;

/**
 * Created by xiangji on 9/15/14.
 */
public class Solution1 {
    public static void main(String[] args){
        Tree T1 = new Tree(14);
        Tree T2 = new Tree(8);
        Tree T3 = new Tree(9);
        Tree T4 = new Tree(12);
        Tree T5 = new Tree(2);
        Tree T6 = new Tree(8);
        Tree T7 = new Tree(13);
        Tree T8 = new Tree(2);
        Tree T9 = new Tree(5);
        T1.l = T2;
        T1.r = T3;
        T2.l = T4;
        T2.r = T5;
        T3.l = T6;
        T3.r = T7;
        T6.l = T8;
        T7.l = T9;
        Question1 q1 = new Question1();
        System.out.println(q1.solution(T1));
    }
}
