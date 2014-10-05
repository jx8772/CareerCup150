package chapter7.Question6;

import java.util.HashMap;

/**
 * Problem: Given a two-dimensional graph with points on it, find a line which passes the most number of points
 * Created by xiangji on 8/27/14.
 */
public class Question6 {
    public static Point[] createPoints() {
        int n_points = 20;
        System.out.println("Points on Graph\n***************");
        Point[] points = new Point[n_points-1];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n_points / 2; i++) {
            Point p = new Point(i, 2.3 * (double)i + 20.0);
            points[i] = p;
            System.out.println(p.toString());
            count1++;
        }
        System.out.println(count1);
        for (int i = 0; i < n_points/2-1; i++) {
            Point p = new Point(i, 3.0 * (double)i + 1.0);
            points[n_points / 2 + i] = p;
            System.out.println(p.toString());
            count2++;
        }
        System.out.println(count2);
        System.out.println("****************\n");
        return points;
    }

    public static void main(String[] args) {
        Point[] points = createPoints();
        Line line = findBestLine(points);
        System.out.println(line.toString());
    }

    public static Line findBestLine(Point[] points){
        Line bestLine = null;
        int bestCount = 0;
        HashMap<Line, Integer> map = new HashMap<Line, Integer>();
        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                Line l = new Line(points[i], points[j]);
                int currCount;
                //if the line already exists, increment the count, otherwise, add a new line
                if(map.containsKey(l)){
                    currCount = map.get(l)+1;
                }
                else{
                    currCount = 1;
                }
                //update the bestLine and bestCount if necessary
                if(bestLine == null || currCount > bestCount){
                    bestLine = l;
                    bestCount = currCount;
                }
                //update the hashmap
                map.put(l, currCount);
            }
        }
        return bestLine;
    }
}
