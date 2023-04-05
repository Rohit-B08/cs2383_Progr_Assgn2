import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

    static class Edge {
        Integer source, direction;

        Edge(int source, int direction) {
            this.source = source;
            this.direction = direction;
        }
    }

    List<List<Integer>> adjacencyList = new ArrayList<>();

    public DirectedGraph(List<Edge> edges) {
        int totalVertices = 0;
        for (Edge edge : edges) {
            totalVertices = Integer.max(totalVertices, Integer.max(edge.source, edge.direction));
        }

        for (int i = 0; i <= totalVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (Edge currentEdge : edges) {
            adjacencyList.get(currentEdge.source).add(currentEdge.direction);
        }
    }

    public void showGraph() {
        int source = 0;

        System.out.println("Adjacency List for the graph is:");
        while (source < adjacencyList.size()) {
            if (!adjacencyList.get(source).isEmpty()) {
                for (int direction = 0; direction < adjacencyList.get(source).size(); direction++) {
                    if (!(adjacencyList.get(source).get(direction) == null)) {
                        System.out.println("(" + source + " -- > " + adjacencyList.get(source).get(direction) + ")\t");
                    }
                }
            }
            source++;
        }
    }

    //Returns the number of vertices
    public int totalVertices() {
        return adjacencyList.size();
    }

    //Returns the number of edges
    public int totalEdges() {
        int totalEdges = 0;

        for (List<Integer> integers : adjacencyList) {
            totalEdges += integers.size();
        }

        return totalEdges;
    }

    //Returns indegree of a vertex
    public int vertexIndegree(int vertex) {
        int totalIndegree = 0;
        int source = 0;

        while (source < adjacencyList.size()) {
            for (int direction : adjacencyList.get(source)) {
                if (direction == vertex) {
                    totalIndegree++;
                }
            }
            source++;
        }

        return totalIndegree;
    }

    //Returns outdegree of a vertex
    public int vertexOutdegree(int vertex) {
        return adjacencyList.get(vertex).size();
    }

    //Inserts a vertex to the existing graph
    public void addVertex(int vertex) {
        if (vertex < adjacencyList.size() && adjacencyList.get(vertex) != null) {
            System.out.println("Vertex already exists");
        } else {
            adjacencyList.add(vertex, new ArrayList<>());
            System.out.println("Vertex " + vertex + " added");
        }
    }

    //Removes a vertex from the graph
    public void removeVertex(int vertex) {
        if (vertex < adjacencyList.size()) {
            int source = 0;

            while (source < adjacencyList.size()) {
                for (int direction = 0; direction < adjacencyList.get(source).size(); direction++) {
                    if (adjacencyList.get(source).get(direction) == vertex) { //removes all the incoming edges
                        adjacencyList.get(source).set(direction, null);
                    }
                }

                if (source == vertex) { //removing the vertex
                    for (int i = 0; i < adjacencyList.get(source).size(); i++) { //removing the outgoing edges
                        adjacencyList.get(source).set(i, null);
                    }
                    //adjacencyList.set(source, null);
                }

                source++;
            }
        }
    }

    //Inserts an edge between two given vertices
    public void addEdge(Edge edge) {
        if (edge.source < adjacencyList.size() && adjacencyList.get(edge.source) != null && adjacencyList.get(edge.source).size() != 0 && adjacencyList.get(edge.source).get(edge.direction) != null) {
            System.out.println("Edge already exists");
        } else if (edge.source < adjacencyList.size()){
            adjacencyList.get(edge.source).add(edge.direction);
            System.out.println("Added edge from " + edge.source + " to " + edge.direction);
        } else {
            addVertex(edge.source);
            adjacencyList.get(edge.source).add(edge.direction);
            System.out.println("Added edge from " + edge.source + " to " + edge.direction);
        }
    }

    //Removes an edge for two given vertices.
    public void removeEdge(int vertex1, int vertex2) {
       for (int direction = 0; direction < adjacencyList.get(vertex1).size(); direction++) {
           if (adjacencyList.get(vertex1).get(direction) == vertex2) {
               adjacencyList.get(vertex1).set(direction, null);
           }
       }
    }
}
