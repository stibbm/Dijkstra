# Dijkstra
Uses Dijkstra's Algorithm to find the shortest pathways between points in a directed graph where the cost of edges is greater than or equal to 0.

## Implementation Details
Uses a priority queue implementation of Dijkstra's algorithm where the value in the queue is based on whether you are the next shortest path that the algorithm will follow.

## How to input data
Reads in graph data from file using the format:
  a source_node_id dest_node_id cost
  e.g.
  a 1 2 3 // there is an edge from 1 to 2 with a cost of 3
  a 2 3 2 // there is an edge from 2 to 3 with a cost of 2
  a 1 3 4 // there is an edge from 1 to 3 with a cost of 4
 
## How datafile is parsed
The data file is parsed by using split(" "); and any line that does not have "a" as the first token will be ignored. All lines containing data should begin with "a "
