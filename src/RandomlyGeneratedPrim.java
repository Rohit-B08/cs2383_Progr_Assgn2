import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class RandomlyGeneratedPrim {

    static class Edge {
        private final char source;
        private final char destination;
        private final int weight;

        public Edge(char source, char destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private final ArrayList<Edge> graph;

    private char startingVertex;

    public RandomlyGeneratedPrim(ArrayList<Edge> graph, char startingVertex) {
        this.graph = graph;
        this.startingVertex = startingVertex;
    }

    public void minSpanTree() {
        ArrayList<Edge> tree = new ArrayList<>();
        Edge minEdge = null;

        for (int i = 0; i < graph.size(); i++) { //loop through the graph
            int minWeight = Integer.MAX_VALUE;
            for (Edge edge : graph) { //loop through the edges in the graph
                boolean dupe1 = false, dupe2 = false;
                if (edge.source == startingVertex) { //if the source of an edge is the starting vertex
                    if (minWeight > edge.weight) { //Determine if there is a lower weighted edge
                        for (Edge vertex : tree) {
                            if (vertex.source == edge.source || vertex.destination == edge.source) {
                                dupe1 = true;
                            }
                            if (vertex.source == edge.destination || vertex.destination == edge.destination) {
                                dupe2 = true;
                            }
                        }
                        if (!dupe1 || !dupe2) { //If the edge is new, swap
                            minWeight = edge.weight; //Swap
                            minEdge = edge;
                        }
                    }
                }
            }

            boolean sourceDupe = false, destinationDupe = false;
            if (minEdge != null) {
                for (Edge edge : tree) {
                    if (edge.source == minEdge.source) {
                        sourceDupe = true;
                    }
                    if (edge.destination == minEdge.destination) {
                        destinationDupe = true;
                    }
                }
                if (!sourceDupe || !destinationDupe) { //Check if it's a duplicate
                    tree.add(minEdge);
                    startingVertex = (minEdge).destination;
                }
            }

        }

        for (Edge edge : tree) {
            System.out.println(edge.source + ", " + edge.destination + ", " + edge.weight);
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        int n = 150; // number of nodes

        // generate adjacency matrix
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // since the matrix is symmetric
                int value = rand.nextInt(2); // generate either 0 or 1 randomly
                if (value == 1) {
                    value = rand.nextInt(1000);
                    graph.add(new Edge((char) (i+65),(char) (j+65), value));
                    graph.add(new Edge((char) (j+65),(char) (i+65), value));
                }
            }
        }

        graph.sort(Comparator.comparingInt(o -> o.source));
        System.out.println("The graph list:");
        for (Edge edge : graph) {
            System.out.println(edge.source + ", " + edge.destination + ", " + edge.weight);
        }

        RandomlyGeneratedPrim pain = new RandomlyGeneratedPrim(graph, 'A');
        System.out.println("===================================================");
        System.out.println("Minimum spanning tree");
        double startTime = System.currentTimeMillis();
        pain.minSpanTree();
        double endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Execution time: " + (endTime - startTime));
    }
}
