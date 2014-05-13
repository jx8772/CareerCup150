package chapter8.question6;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: xiangji
 * Date: 4/3/14
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Puzzle {
    private Piece[] pieces;
    private Piece[][] solution;

    private ArrayList<Edge> inners,outers,flats;
    private ArrayList<Piece> corners;

    public Puzzle() {
        //initilize all the private data structures
    }

    public void sort() {
        for(Piece p : pieces) {
            int flatCount = 0;
            for (Edge e : p.edges) {
                if(e.edgeType == EdgeType.Flat) {
                    flats.add(e);
                    flatCount++;
                } else if (e.edgeType == EdgeType.Inner) {
                    inners.add(e);
                } else if (e.edgeType == EdgeType.Outter) {
                    outers.add(e);
                }
            }
            if (flatCount == 2) {
                corners.add(p);
            }
        }
    }
    public void solve() {
        Edge currentEdge = getExposedEdge(corners.get(0));

        while(currentEdge != null) {
            ArrayList<Edge> opposites = (currentEdge.edgeType == EdgeType.Inner) ? outers : inners;
            for (Edge fittingEdge : opposites) {
                if(currentEdge.fitWithEdge(fittingEdge)) {
                    attachEdges(currentEdge, fittingEdge);
                    removeFromList(currentEdge);
                    removeFromList(fittingEdge);

                    currentEdge = nextExposedEdge(fittingEdge);
                    break;
                }
            }
        }
    }

    private void removeFromList(Edge edge) {
        //remove the edge from corresponding arraylist. e.g. if the edge is flat, remove that edge from flats
    }

    private Edge nextExposedEdge(Edge edge) {
        int next_index = (edge.index + 2) % 4;
        Edge next_edge = edge.parentPiece.edges[next_index];
        if (isExposed(next_edge)) {
            return next_edge;
        }
        return getExposedEdge(edge.parentPiece);
    }

    private boolean isExposed(Edge edge) {
        return edge.edgeType != EdgeType.Flat && edge.attached_to == null;
    }

    private Edge getExposedEdge(Piece p) {
        for (Edge edge : p.edges) {
            if(isExposed(edge)) {
                 return edge;
            }
        }
        return null;
    }

    private void attachEdges(Edge e1, Edge e2) {
        e1.attached_to = e2;
        e2.attached_to = e1;
    }
}
