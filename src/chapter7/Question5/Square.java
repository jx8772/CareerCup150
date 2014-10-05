package chapter7.Question5;

/**
*
* Created by xiangji on 8/26/14.
*/
public class Square {
    double left;
    double right;
    double top;
    double bottom;

    public Square(double left, double right, double top, double bottom){
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public Point getCenter(){
        double centerX = (this.left + this.right)/2;
        double centerY = (this.top + this.bottom)/2;
        return new Point(centerX, centerY);
    }

    /*return a line that cuts the two squares into half respectively*/
    public Line cut(Square s){
        Point middle1 = this.getCenter();
        Point middle2 = s.getCenter();
        //if the two centers are equal, return diagonal
        if(middle1.equals(middle2)){
            return new Line(new Point(left, top), new Point(right, bottom));
        }
        //if the two centers are not equal, return the line crossing the two centers
        else{
            return new Line(middle1, middle2);
        }
    }

    public String toString(){
        return "left: " + left + "; right: " + right + "; top: " + top + "; bottom: " + bottom;
    }
}
