package djigraphv2;

import java.util.ArrayList;

public class Node {
	final String label;
	final int nodeID;
	final ArrayList<Edge> edges;
	
	/**
	 * Stores node information and edges that originate from
	 * this node
	 * @param label
	 * @param nodeID
	 */
	public Node(String label, int nodeID){
		this.label = label;
		this.nodeID = nodeID;
		this.edges = new ArrayList<>();
	}
	
	public String getLabel(){
		return this.label;
	}
	
	public int getNodeID(){
		return this.nodeID;
	}
	
	public Edge getEdge(int index){
		return edges.get(index);
	}
	
	public int getEdgeCount(){
		return this.edges.size();
	}
	
	/**
	 * Origin of passed edge is assumed to be this node
	 * @param edge
	 */
	public void addEdge(Edge edge){
		edges.add(edge);
	}
	
	/**
	 * String representation of a node
	 */
	public String toString(){
		return label + " , NodeID = " + nodeID;
	}
}
