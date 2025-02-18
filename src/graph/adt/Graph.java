package graph.adt;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(Vertex v){
        this.vertices.remove(v);
    }

    public void addEdge(Vertex v1, Vertex v2, Integer weight) {
        if (!isWeighted) {
            weight = null;
        }
        v1.addEdge(v2, weight);
        if(!this.isDirected) {
            v2.addEdge(v1, weight);
        }
    }

    public void removeEdge(Vertex v1, Vertex v2) {
        v1.removeEdge(v2);
        if(!this.isDirected) {
            v2.removeEdge(v1);
        }
    }

    public Vertex getVertexByValue(String value) {
        //This is weird as well. Not sure what we should do if the vertex doesn't exist in the graph
        for(Vertex v: this.vertices) {
            if (v.getData() == value) {
                return v;
            }
        }

        return null;
    }

    public void print() {
        for(Vertex v: this.vertices) {
            v.print(isWeighted);
        }
    }
}
