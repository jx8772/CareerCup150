package chapter7.Question6;

/**
 * Created by xiangji on 8/27/14.
 */
public class Line {
    //allow for approximate comparison betwee double value
    public static double epsilon = 0.0001;

    //properties for non-vertical line
    public double slope;
    public double yintercept;

    //properties for vertical line
    boolean infiniteSlope = false;
    public double xintercept;

    public Line(Point p1, Point p2){
        //if the line is vertical
        if(p1.x == p2.x){
            infiniteSlope = true;
            xintercept = p1.x;
        }
        else{
            slope = (p1.y-p2.y)/(p1.x-p2.x);
            yintercept = p1.y - slope*p1.x;
        }

        // floor all properties
        this.slope = floor(this.slope);
        this.xintercept = floor(this.xintercept);
        this.yintercept = floor(this.yintercept);
    }

    public double floor(double val){
        //this statement is a must, otherwise the java will have weird result
        int precision = (int)(1.0/epsilon);
        return (double)Math.round(this.slope * precision) / precision;
    }

    public boolean isApproxEqual(double a, double b){
        return Math.abs(a-b) < epsilon;
    }

    @Override
    public int hashCode(){
        if(infiniteSlope){
            return (int)xintercept;
        }
        else{
            return (int)slope+(int)yintercept;
        }
    }

    @Override
    public boolean equals(Object o){
        Line l = (Line)o;
        //one is infinite slope, the other is not infinite slope
        if(this.infiniteSlope != l.infiniteSlope){
            return false;
        }
        //both are infinite slope
        if(this.infiniteSlope == l.infiniteSlope && this.infiniteSlope){
            return this.xintercept == l.xintercept;
        }
        //both are not infinite slope
        else{
            return (isApproxEqual(this.slope, l.slope) && isApproxEqual(this.yintercept, l.yintercept));
        }
    }

    public String toString(){
        if(infiniteSlope){
            return "xintercept: " + xintercept;
        }
        else{
            return "slope: " + slope + "; yintercept: " + yintercept;
        }
    }
}
