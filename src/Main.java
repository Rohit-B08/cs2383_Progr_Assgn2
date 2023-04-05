import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<DirectedGraph.Edge> edges = Arrays.asList(new DirectedGraph.Edge(0, 1),
                new DirectedGraph.Edge(1, 2),
                new DirectedGraph.Edge(2, 4),
                new DirectedGraph.Edge(4, 1),
                new DirectedGraph.Edge(3, 2),
                new DirectedGraph.Edge(2, 5),
                new DirectedGraph.Edge(3, 4),
                new DirectedGraph.Edge(5, 4),
                new DirectedGraph.Edge(1, 1));

        DirectedGraph graph = new DirectedGraph(edges);
        System.out.println();
        System.out.println("Total number of vertices: " + graph.totalVertices());
        System.out.println("Total number of edges: " + graph.totalEdges());
        System.out.println("The Indegree of the current vertex: " + graph.vertexIndegree(4));
        System.out.println("The Outdegree of the current vertex: " + graph.vertexOutdegree(2));
        graph.addVertex(6);
        graph.addEdge(new DirectedGraph.Edge(6, 1));
        graph.showGraph();
        graph.removeVertex(1);
        graph.removeEdge(2, 4);
        graph.showGraph();
    }
}