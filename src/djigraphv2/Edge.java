package djigraphv2;

public class Edge {
	final int destinationID, cost;
	
	/**
	 * Stores edge information
	 * @param destinationID
	 * @param cost
	 */
	public Edge(int destinationID, int cost){
		this.destinationID = destinationID;
		this.cost = cost;
	}
	
	/**
	 * String representation of edge
	 */
	public String toString(){
		return "Destination : " + destinationID + " , Cost : " + cost;
	}
}
