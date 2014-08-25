package chapter7;

/**
 * Problem: Given two lines on a cartesian plane, determine whether the two lines would intercept.
 * Created by xiangji on 8/25/14.
 */
public class Question3 {
    public static void main(String[] args){
        Line l1 = new Line(1,3);
        Line l2 = new Line(2,3.123222342);
        Line l3 = new Line(2,3.12222334);
        System.out.println(l1.intercept(l2));
        System.out.println(l2.intercept(l3));
        System.out.println(l1.intercept(l3));
    }
}
