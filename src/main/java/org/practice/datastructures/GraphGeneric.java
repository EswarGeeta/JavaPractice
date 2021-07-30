package org.practice.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class GraphGeneric <V>
{
	Map<V, Set<V>> edges;
	
	public GraphGeneric(){
		edges = new HashMap<>();
	}
	
	public void addEdge(V src, V dest) {
		if(!edges.containsKey(src))
			edges.put(src, new HashSet<V>());
		if(!edges.containsKey(dest))
			edges.put(dest, new HashSet<V>());
		edges.get(src).add(dest);
//		edges.get(dest).add(src);
	}

	public void printGraph() {
		for(Entry<V, Set<V>> entry : edges.entrySet()) {
			System.out.print("Adjlist of " + entry.getKey() + ": ");
			for(V node : entry.getValue()) {
				System.out.print(node + ", ");
			}
		}
	}
	
	public void DFS() {
		Set<V> visited = new HashSet<>();
		edges.keySet().forEach(V -> DFSUtil(V, visited));
	}

	
    private void DFSUtil(V vertix, Set<V> visited) {
    	if(!visited.contains(vertix)) {
        	System.out.println(vertix);
        	visited.add(vertix);
        	edges.get(vertix).forEach(adj -> {
    	        		if(!visited.contains(adj)) 
    	        			DFSUtil(adj, visited);
        	});    		
    	}
	}

/*	public static void main(String[] args)
    {
    	Graph<Integer> graph = new Graph<>();
    	graph.addEdge(1, 2);
    	graph.addEdge(2, 4);
    	graph.addEdge(3, 2);
    	graph.addEdge(3, 1);
    	graph.addEdge(1, 3);
    	graph.addEdge(1, 2);

    	graph.printGraph();
    	graph.DFS();
    }
 */
}