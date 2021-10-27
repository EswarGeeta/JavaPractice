package org.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.*;

public class GenericGraph<T> {
    Map<T, Set<T>> edges;
    boolean biDirectional;

    public GenericGraph(boolean biDirectional) {
        this.edges = new HashMap<>();
        this.biDirectional = biDirectional;
    }

    public void addVertix(T vertix) {
        if(!edges.containsKey(vertix))
            this.edges.put(vertix, new HashSet<>());
    }

    public void addEdge(T source, T destination) {
        if (!edges.containsKey(source)) {
            addVertix(source);
        }
        if (!edges.containsKey(destination)) {
            addVertix(destination);
        }
        edges.get(source).add(destination);
        if (this.biDirectional) {
            edges.get(destination).add(source);
        }
    }

    public void printGraph() {
        for(T vertix: edges.keySet()) {
            System.out.println("Edges for vertix" + vertix);
            edges.get(vertix).forEach(System.out::print);
        }
    }

    public int countEdges() {
        int count = 0;
        for(T vertix: edges.keySet()) {
            count += edges.get(vertix).size();
        }
        return this.biDirectional ? count / 2 : count;
    }

    public int countVertices() {
        return edges.size();
    }

    public void DFS() {
        Set<T> visited = new HashSet<>();
        edges.keySet().forEach(vertix -> {
            System.out.println("Visiting vertix" + vertix);
            DFSUtil(vertix, visited);
        });
    }
    public void DFSUtil(T vertix, Set<T> visited) {
        if(!visited.contains(vertix)) {
            System.out.println(vertix);
            visited.add(vertix);
            edges.get(vertix).forEach(adj -> {
//                System.out.println("going to visit " + adj + " if not already visited" );
                if(!visited.contains(adj))
                    DFSUtil(adj, visited);
            });
        }
    }

    public boolean isCyclic() {
        Set<T> visited = new HashSet<>();
        Set<T> visitedInRec = new HashSet<>();
        for(T vertix : edges.keySet()) {
            if(isCyclicUtil(vertix, visited, visitedInRec))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(T vertix, Set<T> visited, Set<T> visitedInRec) {
        if(visitedInRec.contains(vertix))
            return true;
        if(visited.contains(vertix))
            return false;

        visited.add(vertix);
        visitedInRec.add(vertix);

        for(T adj : edges.keySet()) {
            if( isCyclicUtil(adj, visited, visitedInRec) )
                return true;
        }
        visitedInRec.remove(vertix);
        return false;
    }

    public void BFS() {
        Set<T> visited = new HashSet<>();
        for(T vertix : edges.keySet()) {
            if(!visited.contains(vertix)) {
                BFS(vertix, visited);
            }
        }
    }

    public void BFS(T vertix, Set<T> visited) {
        Queue<T> visitQueue = new LinkedList<>();
        visitQueue.add(vertix);
//        for(T vertix : edges.keySet()) {
//            if(!visited.contains(vertix)) {
//                visitQueue.add(vertix);
//            }
//        }
        while(!visitQueue.isEmpty()) {
            T vert = visitQueue.poll();
            if(!visited.contains(vert)) {
                System.out.println(vert);
                visited.add(vert);
                edges.get(vert).forEach( adj -> {
                    if(!visited.contains(adj)) {
                        visitQueue.add(adj);
                    }
                });
            }
        }

    }

    public void topologicalSort() {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        edges.keySet().forEach(vertix -> {
            if(!visited.contains(vertix)) {
                topologicalSortUtil(vertix, visited, stack);
            }
        });
        System.out.println(" size of stack " + stack.size());
        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }

    public void topologicalSortUtil(T vertix, Set<T> visited, Stack<T> stack) {
        System.out.println("going to visit vertix " + vertix);
        visited.add(vertix);
        edges.get(vertix).forEach(adj -> {
            System.out.println("going to visit the adj " + adj);
            if(!visited.contains(adj)) {
                topologicalSortUtil(adj, visited, stack);
            }
        });
        stack.push(vertix);
    }

    // This is a topological sorting based on BFS. This same algorithm can be used to check if a graph has cycle.
    public void topologicalSortWithKahn() {
        Map<T, Integer> indegreeMap = new HashMap<>();
//        edges.values().forEach(adjList -> adjList.forEach());
        for(Set<T> adjList : edges.values()) {
            for(T adj : adjList) {
                if (indegreeMap.containsKey(adj))
                    indegreeMap.put(adj, indegreeMap.get(adj) + 1);
                else
                    indegreeMap.put(adj, 1);
            }
        }
        Queue<T> bfsQueue = new LinkedList<>();
        List<T> topologicalOrder = new ArrayList<>();
        for(T vertix : edges.keySet()) {
            if(!indegreeMap.containsKey(vertix))
                bfsQueue.add(vertix);
        }

        while(!bfsQueue.isEmpty()) {
            T vertix = bfsQueue.remove();
            topologicalOrder.add(vertix);
            edges.get(vertix).forEach(adj -> {
                if (indegreeMap.get(adj) == 1) {
                    indegreeMap.remove(adj);
                    bfsQueue.add(adj);
                } else {
                    indegreeMap.put(adj, indegreeMap.get(adj) - 1);
                }
            });
        }

        if (topologicalOrder.size() == edges.size()) {
            System.out.println("Topological sort: ");
            topologicalOrder.forEach(System.out::println);
        } else {
            System.out.println("Graph is not an DAG, topological sorting is not possible");
        }
    }

    public static void main(String[] args) {
//        org.practice.datastructures.graphs.GenericGraph<Integer> graph = new org.practice.datastructures.graphs.GenericGraph<>(true);
//        graph.addEdge(0,1);
//        graph.addEdge(1,2);
//        graph.addEdge(2,3);
//        graph.addEdge(3,4);
//        graph.addEdge(4,5);
//        graph.addEdge(5,6);
//        graph.addEdge(6,7);
//        graph.addEdge(7,8);
//        graph.addEdge(8,0);
//        graph.addEdge(0,2);
//        graph.addEdge(0,5);
//        graph.addEdge(2,4);
//        graph.addEdge(3,7);
//        graph.addEdge(8,5);
//
//        graph.addEdge(9,10);
//        graph.addEdge(10,11);
//        graph.addEdge(11,9);
//        graph.printGraph();
//        graph.DFS();
//        graph.BFS();

        GenericGraph<Integer> graph = new GenericGraph<>(false);
        graph.addEdge(5,0);
        graph.addEdge(5,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,0);
        graph.addEdge(4,1);

//        graph.printGraph();
//        graph.topologicalSort();
        graph.topologicalSortWithKahn();

    }
}
