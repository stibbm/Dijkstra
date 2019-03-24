package djigraphv2;

/**
 * Used to track the node path information used when computing
 * the shortest path between nodes using Djikstra's algorithm
 * @author matt
 *
 */
public class DJNode {
	
	int nodeID, cost, prevNode;
	// visited keeps track of whether or not a path to the given node has 
	// been found yet
	//
	// done keeps track of whether the shortest path to the given node has
	// been found yet
	boolean visited, done;
	
	/**
	 * Creates a new DJNode which contains the logic/info
	 * necessary to run the Djikstra algorithm on a graph.
	 * @param nodeID
	 */
	public DJNode(int nodeID){
		this.nodeID = nodeID;
		this.cost = Integer.MAX_VALUE;
		this.prevNode = -1;
		this.visited = false;
		this.done = false;
	}
	
	/**
	 * String representation of DJNode
	 */
	public String toString(){
		return "NodeID : " + nodeID + " ; Cost : " + cost + " ; prevNode : " + prevNode;
	}
}
