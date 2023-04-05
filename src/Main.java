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
        graph.showGraph();
    }
}