package org.practice.datastructures;

import java.util.HashSet;
import java.util.Set;

class GraphMatrix { 
	int[][] edges;
	int vertexCount;
	public GraphMatrix( int[][] adjmat) {
		System.out.println(adjmat.length);
		this.vertexCount = adjmat.length;
		edges = new int[ adjmat.length][ adjmat.length];
		for (int i=0; i<vertexCount; i++) {
			for(int j=0; j<vertexCount; j++) { 
				edges[i][j] = adjmat[i][j];
}
}
}

	public void getMstByPrims( ) {
		System.out.println("Prims MST ");
		Set<Integer> visited = new HashSet<>();
		visited.add(0);

		while(visited.size() < vertexCount) {
			int min = Integer.MAX_VALUE, x = -1, y = -1;
			for(int i=0; i<vertexCount; i++) {
				if(visited.contains(i)) {
					for(int j=0; j<vertexCount ; j++) {
						if(!visited.contains(j) && edges[i][j] != 0)
						if(min > edges[i][j]) {
							min = edges[i][j];
							x = i;
							y = j;
						}
					}
				}
			}
			System.out.println("Edge " + x + " " + y + " , Weight: " + min);
			visited.add(y);
		}
	}

	public void dijkstrasAlgorithm() {
		
	}

public static void main(String[] args) { 
	int[][] adjmat = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
   { 0, 42, 66, 31, 0 } };
	GraphMatrix graph = new GraphMatrix(adjmat);
	graph.getMstByPrims();
}
}
