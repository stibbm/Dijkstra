package djigraphv2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	static PrintWriter pw;

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		pw = new PrintWriter("Outfile.txt");
		// TODO Auto-generated method stub
		Graph g = new Graph();
		
		File data = new File("USA-road-d.NY.gr");
		// File data = new File("TestDataSmall.txt");
		readInGraphFile(data, g);
		Djikstra djikstra = new Djikstra(g);
		HashMap<Integer, DJNode> DJNodes = djikstra.shortestPath(1);
		
		pw.println("shortest path to 5 from 1");
		printShortestPath(1, 5, g);
		pw.println();
		int cost = costShortestPath(1, 5, g);
		pw.println("cost = " + cost);
		System.out.println("\ncost = " + cost);

		System.out.println();
		pw.println();
		pw.println("shortest path to 6 from 1");
		printShortestPath(1, 6, g);
		pw.println();
		int cost2 = costShortestPath(1, 6, g);
		pw.println("cost = " + cost2);
		System.out.println("\ncost = " + cost2);
		System.out.println();
		pw.println();
		pw.println("shortest path to 4 from 1");
		printShortestPath(1, 4, g);
		int cost3 = costShortestPath(1, 4, g);
		pw.println();
		pw.println("cost = " + cost3);
		System.out.println("\ncost = " + cost3);



		pw.close();
		System.exit(0);
		
		// g = new Graph();
		
		// g.addNode("node1", 1);
		// g.addNode("node2", 2);
		// g.addNode("node3", 3);
		// g.addNode("node4", 4);
		// g.addNode("node5", 5);
		
		// g.addEdge(1, 2, 1);
		// g.addEdge(1, 3, 2);
		// g.addEdge(2, 4, 10);
		// g.addEdge(2, 3, 1);
		// g.addEdge(3, 2, 5);
		// g.addEdge(3, 4, 40);
		
		Djikstra dj = new Djikstra(g);
		HashMap<Integer, DJNode> nodes = dj.shortestPath(1);
		for(Integer key : nodes.keySet()){
			System.out.println("path destination nodeID : " + key);
			System.out.println("prevNode : " + nodes.get(key).prevNode + " ; Cost : " + nodes.get(key).cost);
			System.out.println();
		}
		
		System.out.println();
		
		printShortestPath(1, 4, g);

	}
	
	
	/**
	 * Prints out the shortest path between the nodes with the given nodeID's
	 * @param sourceID
	 * @param destinationID
	 * @param g
	 */
	public static void printShortestPath(int sourceID, int destinationID, Graph g){
		Djikstra djikstra = new Djikstra(g);
		HashMap<Integer, DJNode> paths = djikstra.shortestPath(sourceID);
		// for (DJNode path : paths.values()) {
		// System.out.println(path.nodeID);
		// System.out.println(path.prevNode);
		// System.out.println(path.cost);
		// System.out.println();
		// }
		printPath(paths, destinationID);
	}
	
	/**
	 * returns the path cost of getting to the destination with the given paths
	 * @param paths
	 * @param destination
	 * @param total_cost
	 * @return
	 */
	public static int costShortestPath(HashMap<Integer, DJNode> paths, int destination) {
		DJNode curr = paths.get(destination);
		return curr.cost;
	}
	
	/**
	 * returns the cost of the shortest path found in graph g from the source node
	 * to the destination node
	 * @param sourceID
	 * @param destinationID
	 * @param g
	 * @return
	 */
	public static int costShortestPath(int sourceID, int destinationID, Graph g){
		Djikstra djikstra = new Djikstra(g);
		HashMap<Integer, DJNode> nodes = djikstra.shortestPath(sourceID);
		int cost = nodes.get(destinationID).cost;
		return cost;
	}
	
	/**
	 * Reads graph data from file and inputs it into the graph passed
	 * @param file
	 * @param g
	 * @throws FileNotFoundException
	 */
	public static void readInGraphFile(File file, Graph g) throws FileNotFoundException{
		Scanner fscan = new Scanner(file);
		while(fscan.hasNextLine()){
			String[] tokens = fscan.nextLine().split(" ");
			if(tokens[0].equals("a")){
				int sourceID = Integer.parseInt(tokens[1]);
				int destinationID = Integer.parseInt(tokens[2]);
				int cost = Integer.parseInt(tokens[3]);
				
				if(!g.nodes.containsKey(sourceID)){
					g.addNode("node" + sourceID, sourceID);
				}
				
				if(!g.nodes.containsKey(destinationID)){
					g.addNode("node" + destinationID, destinationID);
				}
				
				g.addEdge(sourceID, destinationID, cost);
			}
		}
		fscan.close();
	}
	
	/**
	 * Starting from the destination this method recursively
	 * calls itself using the previous node as the new destination
	 * in the next call until the node with the given nodeID
	 * has a prevNode equal to 0 which indicates that we have
	 * reached the source node that the paths were computed
	 * relative to.
	 * @param paths
	 * @param destination
	 */
	public static boolean printPath(HashMap<Integer, DJNode> paths, int destination){
		DJNode curr = paths.get(destination);
		if(curr.prevNode==-1){
			System.out.println("destination : " + destination + " is unreachable");
			//System.out.println("exit");
			//System.exit(0);
			return false;
		}
		else{
			if(curr.prevNode>0){
				boolean hasPath = printPath(paths, curr.prevNode);
				if(hasPath){
					System.out.print(" -> " + curr.nodeID);
					pw.print(" -> " + curr.nodeID);
					return true;
				}
				else{
					return false;
				}
			}else{
				System.out.print(curr.nodeID);
				pw.print("" + curr.nodeID);
				return true;
			}
		}
	}

}
