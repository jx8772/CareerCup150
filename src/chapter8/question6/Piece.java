package chapter8.question6;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/3/14
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Piece {
    public Edge[] edges;
    public boolean isCorner(Piece p) {
        int flatCount = 0;
        for (Edge e : p.edges) {
            if(e.edgeType == EdgeType.Flat) {

                flatCount++;
            }
        }
        if (flatCount == 2) {
            return true;
        } else
            return false;
    }
}
