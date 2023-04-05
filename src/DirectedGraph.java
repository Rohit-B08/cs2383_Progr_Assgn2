import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {

    static class Edge {
        int source, direction;

        Edge(int source, int direction) {
            this.source = source;
            this.direction = direction;
        }
    }

    List<List<Integer>> adjacencyList =new ArrayList<>();

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

        int size = adjacencyList.size();
        System.out.println("Adjacency List for the graph is:");
        while (source < size) {
            for (int direction : adjacencyList.get(source)) {
                System.out.println("(" + source + " -- > " + direction + ")\t");
            }
            source++;
        }
    }
}
