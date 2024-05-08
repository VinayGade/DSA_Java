package graph.problems;

import java.util.*;

// LC 1971. Find if Path Exists in Graph

/*
There is a bi-directional graph with n vertices,
where each vertex is labeled from 0 to n - 1 (inclusive).
The edges in the graph are represented as a 2D integer array edges,
where each edges[i] = [ui, vi] denotes a bi-directional edge
between vertex ui and vertex vi.
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists
from vertex source to vertex destination.

Given edges and the integers n, source, and destination,
return true if there is a valid path from source to destination, or false otherwise.

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

* */

public class ValidPath {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        // adjacency list graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            graph.computeIfAbsent(u, value ->
                    new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value ->
                    new ArrayList<>()).add(u);
        }

        boolean[] vertexes = new boolean[n];
        /*
        for(int i=0; i<n; i++)
            vertexes[i] = false;
         */

        vertexes[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(curr == destination)
                return true;

            for(int neighbor : graph.get(curr)){
                if(!vertexes[neighbor]){
                    q.add(neighbor);
                    vertexes[neighbor] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0, destination = 2;

        boolean valid = validPath(n, edges, source, destination);
        System.out.println("valid Path from source "+source+" to destination "+ destination +
                " exists? "+valid);
    }
}
