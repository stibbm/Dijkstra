package djigraphv2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Djikstra {
	final Graph g;
	
	/**
	 * Stores graph to be able to do djikstra shortest
	 * path calculations with
	 * @param g
	 */
	public Djikstra(Graph g){
		this.g = g;
	}
	
	/**
	 * Returns HashMap<Integer, DJNode> paths which contains
	 * all of the information of the shortest paths from the 
	 * passed source node to all other reachable nodes in the graph
	 * @param sourceID
	 * @return
	 */
	public HashMap<Integer, DJNode> shortestPath(int sourceID){
		HashMap<Integer, DJNode> paths = new HashMap<>();
		
		for(Integer nodeID : g.nodes.keySet()){
			paths.put(nodeID.intValue(), new DJNode(nodeID));
		}
		
		// custom comparator for DJNode that will be used in PQ
		// s o that PQ will return the node with the least cost when 
		// "remove()" is called
		Comparator<DJNode> comparator = new DJNodeComparator();
		PriorityQueue<DJNode> pq = new PriorityQueue<>(3, comparator);
		
		DJNode djSource = paths.get(sourceID);
		djSource.cost = 0;
		djSource.visited = true;
		djSource.prevNode=0;
		
		pq.add(djSource);
		
		// while the priority queue is not empty keep going
		while(!(pq.isEmpty())){
			// set curr to the DJNode with the smallest cost value
			DJNode curr = pq.remove();
			curr.done = true;
			//System.out.println("nodeID : " + curr.nodeID);
			// look through edge destinations
			for(Edge edge : g.nodes.get(curr.nodeID).edges){
				DJNode dest = paths.get(edge.destinationID);
				// add dest to pq if not visited yet and
				// set the vars accordingly
				if(dest.visited==false){
					dest.cost = curr.cost + edge.cost;
					dest.visited = true;
					dest.prevNode = curr.nodeID;
					pq.add(dest);
				}
				// if least cost path has not yet been found, check
				// if the path from curr to dest is a cheaper path and
				// if true then update the path information
				else if(dest.done==false
						&& dest.cost > (curr.cost + edge.cost)){
					dest.cost = curr.cost + edge.cost;
					dest.prevNode = curr.nodeID;
				}
			}
		}
		
		
		return paths;
	}
}
