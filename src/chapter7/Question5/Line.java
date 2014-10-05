package chapter7.Question5;

/**
* Created by xiangji on 8/25/14.
*/
public class Line {
    private double epsilon = 0.0001;
    public double a; //a is the slope of line
    public double b; //b is the yintercept of line

    public Line(double a, double b){
        this.a = a;
        this.b = b;
    }

    public Line(Point p1, Point p2){
        if(Math.abs(p1.x-p2.x) < epsilon){
            this.a = Integer.MAX_VALUE;
        }
        else{
            this.a = (p2.y-p1.y)/(p2.x-p1.x);
        }
        this.b = p1.y - this.a*p1.x;
    }

    public boolean isApproxEqual(Line l ){
        if(Math.abs(this.a-l.a) < epsilon && Math.abs(this.b - l.b) < epsilon){
            return true;
        }
        return false;
    }

    public boolean intercept(Line l){
        return ((Math.abs(l.a - this.a) > epsilon) || (Math.abs(l.b - this.b) < epsilon));
    }

    public String toString(){
        return "slope is: " + a + "; yintercept is: " + b;
    }
}
