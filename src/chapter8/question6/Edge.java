package chapter8.question6;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/3/14
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    EdgeType edgeType;
    Piece parentPiece;
    int index;
    Edge attached_to;

    boolean fitWithEdge(Edge e) {
        if(this.edgeType == EdgeType.Inner && e.edgeType == EdgeType.Outter)
            return true;
        else if (this.edgeType == EdgeType.Outter && e.edgeType == EdgeType.Inner)
            return true;
        else
            return false;
    }
}
