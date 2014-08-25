package chapter7;

/**
 * Created by xiangji on 8/25/14.
 */
public class Line {
    private double epsilon = 0.00001;
    private double a; //a is the slope of line
    private double b; //b is the yintercept of line

    public Line(double a, double b){
        this.a = a;
        this.b = b;
    }

    public boolean intercept(Line l){
        return ((Math.abs(l.a - this.a) > epsilon) || (Math.abs(l.b - this.b) < epsilon));
    }
}
