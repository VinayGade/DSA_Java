package graph.adt;

import java.util.ArrayList;

class GraphTraverser {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());

        for (Edge e: start.getEdges()) {
            Vertex neighbor = e.getEnd();
            if (!visitedVertices.contains(neighbor)) {

                System.out.println(neighbor.getData());

                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    public static void breadthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        Queue visitQueue = new Queue();
        visitQueue.enqueue(start);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.dequeue();
            System.out.println(current.getData());

            for(Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();
                if(!visitedVertices.contains(neighbor)) {
                    visitQueue.enqueue(neighbor);
                    visitedVertices.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices = new ArrayList<Vertex>();
        visitedVertices.add(startingVertex);

        System.out.println("BFS (Breadth First Search)");
        GraphTraverser.breadthFirstTraversal(startingVertex, visitedVertices);

        System.out.println("DFS (Depth First Search)");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices);
    }
}