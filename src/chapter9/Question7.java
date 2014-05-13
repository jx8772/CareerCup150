package chapter9;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 5/12/14
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Question7 {
    public static void main(String[] args){
        Color[][] image = {{Color.Red,Color.Red,Color.Red,Color.Red,Color.Red},{Color.Blue,Color.Blue,Color.Blue,Color.Red,Color.Red},
                {Color.Red,Color.Blue,Color.Blue,Color.Blue,Color.Red},{Color.Red,Color.Red,Color.Blue,Color.Red,Color.Red},
                {Color.Red,Color.Blue,Color.Red,Color.Red,Color.Red}};
        paintFill(image, 0, 0, Color.Green);
        return;
    }

    //method 1: DFS, use recursive
//    enum Color {
//        Green,Yellow,Red,Blue;
//    }
//
//    public static void paintFill(Color[][] image, int x, int y, Color paintColor){
//        paintFill(image, x, y, image[y][x], paintColor);
//    }
//
//    public static void paintFill(Color[][] image, int x, int y, Color originalColor, Color paintColor){
//        if(x < 0 || x >= image[0].length || y < 0 || y >= image.length || image[y][x] != originalColor){
//            return;
//        }
//        //fill the color in (x,y)
//        if(image[y][x] != paintColor){
//            image[y][x] = paintColor;
//        }
//        //fill the up cell
//        paintFill(image, x, y-1, originalColor, paintColor);
//        //fill the down cell
//        paintFill(image, x, y+1, originalColor, paintColor);
//        //fill the left cell
//        paintFill(image, x-1, y, originalColor, paintColor);
//        //fill the right cell
//        paintFill(image, x+1, y, originalColor, paintColor);
//        return;
//    }

    //method 2: use BFS
    enum Color {
        Green,Yellow,Red,Blue;
    }

    public static class Position {
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void paintFill(Color[][] image, int x, int y, Color paintColor){
        paintFill(image, x, y, image[y][x], paintColor);
    }

    public static void paintFill(Color[][] image, int x, int y, Color originalColor, Color paintColor){
        Queue<Position> queue = new LinkedList<Position>();
        queue.add(new Position(x,y));
        while(!queue.isEmpty()){
            Position temp = queue.remove();
            //if (temp.x, temp.x can be filled
            if(fill(image, temp.x, temp.y, originalColor, paintColor)){
                //add the up cell
                queue.add(new Position(temp.x,temp.y-1));
                //add the down cell
                queue.add(new Position(temp.x,temp.y+1));
                //add the left cell
                queue.add(new Position(temp.x-1,temp.y));
                //add the right cell
                queue.add(new Position(temp.x+1,temp.y));
            }
        }
    }

    private static boolean fill(Color[][] image, int x, int y, Color originalColor, Color paintColor){
        if(x < 0 || x >= image[0].length || y < 0 || y >= image.length || image[y][x] != originalColor){
            return false;
        }
        else{
            image[y][x] = paintColor;
            return true;
        }
    }
}
