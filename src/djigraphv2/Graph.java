package djigraphv2;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	final HashMap<Integer, Node> nodes;
	final HashMap<String, Node> nodes_string;
	final HashMap<Integer, ArrayList<Edge>> neighbors;
	
	/**
	 * Graph default constructor
	 */
	public Graph(){
		this.nodes = new HashMap<>();
		this.nodes_string = new HashMap<>();
		this.neighbors = new HashMap<>();
	}
	
	/**
	 * Add node to the graph
	 * adds key, node pairs to the lookup hashmaps
	 * adds key, edgelist pair to the neighbor hashmap
	 * @param label
	 * @param nodeID
	 */
	public void addNode(String label, int nodeID){
		// Node node = new Node(label, nodeID);
		nodes.put(nodeID, new Node(label, nodeID));
		nodes_string.put(label, nodes.get(nodeID));
		neighbors.put(nodeID, new ArrayList<Edge>());
	}
	
	/**
	 * Add edge to the graph
	 * @param sourceID
	 * @param destinationID
	 * @param cost
	 */
	public void addEdge(int sourceID, int destinationID, int cost){
		// Edge edge = new Edge(destinationID, cost);
		nodes.get(sourceID).addEdge(new Edge(destinationID, cost));
		neighbors.get(sourceID).add(nodes.get(sourceID).getEdge(nodes.get(sourceID).getEdgeCount() - 1));
	}
	
	/**
	 * Print out the nodes that are currently stored in the graph
	 */
	public void printNodes(){
		for(Node node : nodes.values()){
			System.out.println(node);
		}
	}
	
	
}
