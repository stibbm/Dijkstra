package djigraphv2;

import java.util.Comparator;

public class DJNodeComparator implements Comparator<DJNode> {
	
	// comparator used for the priority queue
	// compares DJNodes such that the DJNode with the lowest
	// cost is taken from the priority queue when remove()
	// is called
	
	public int compare(DJNode dj1, DJNode dj2){
		return dj1.cost-dj2.cost;
	}
}
