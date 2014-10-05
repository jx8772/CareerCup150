package chapter7.Question5;

/**
* Created by xiangji on 8/27/14.
*/
public class Question5 {
    public static boolean doTest(Square s1, Square s2, Line l){
        Line line = s1.cut(s2);
        if(!line.isApproxEqual(l)){
            System.out.println("test unsuccessful");
            System.out.println(s1.toString());
            System.out.println(s2.toString());
            System.out.println(l.toString());
            return false;
        }
        else{
            System.out.println("test successful");
            return true;
        }
    }

    public static void doTests(){
        //not overlapping
        doTest(new Square(1,5,5,7), new Square(4,6,6,8), new Line(0.5,4.5));

        //more tests need to be done
    }

    public static void main(String[] args){
       doTests();
    }
}
