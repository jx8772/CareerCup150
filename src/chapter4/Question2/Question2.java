package chapter4.Question2;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Given a directed graph, design an algorithm to find out whether there is a route between two nodes
 * Created by xiangji on 8/13/14.
 */
public class Question2 {
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[2];
		Node end = n[5];
		System.out.println(bfs(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

    public static boolean bfs(Graph g, Node start, Node end){
        Queue<Node> queue = new LinkedList<Node>();
        Node[] nodes = g.getNodes();
        for(Node n : nodes){
            n.state = State.Unvisited;
        }
        start.state = State.Visiting;
        queue.add(start);
        while(!queue.isEmpty()) {
            //dequeue
            Node curr = queue.poll();
            for(Node n : curr.getAdjacent()){
                //if the neighbor has not been visited, change its state to visiting and push it to queue
                if(n.state == State.Unvisited){
                    //reached the end node
                    if(n == end){
                        return true;
                    }
                    //otherwise, enqueue its neighbor
                    else{
                        n.state = State.Visiting;
                        queue.add(n);
                    }
                }
            }
            curr.state = State.Visited;
        }
        return false;
    }
}
