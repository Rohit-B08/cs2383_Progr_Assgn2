import java.util.ArrayList;

public class Prim {

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

    public Prim(ArrayList<Edge> graph, char startingVertex) {
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
                if (!sourceDupe && !destinationDupe) { //Check if it's a duplicate
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
        Edge Edge1 = new Edge('A', 'B', 9);
        Edge Edge2 = new Edge('A', 'D', 15);
        Edge Edge3 = new Edge('A', 'E', 20);
        Edge Edge4 = new Edge('B', 'C', 17);
        Edge Edge5 = new Edge('B', 'D', 7);
        Edge Edge6 = new Edge('B', 'A', 9);
        Edge Edge7 = new Edge('C', 'B', 17);
        Edge Edge8 = new Edge('C', 'D', 14);
        Edge Edge9 = new Edge('C', 'F', 12);
        Edge Edge10 = new Edge('D', 'A', 15);
        Edge Edge11 = new Edge('D', 'B', 7);
        Edge Edge12 = new Edge('D', 'C', 14);
        Edge Edge13 = new Edge('D', 'E', 5);
        Edge Edge14 = new Edge('E', 'A', 20);
        Edge Edge15 = new Edge('E', 'D', 5);
        Edge Edge16 = new Edge('E', 'F', 12);
        Edge Edge17 = new Edge('E', 'G', 10);
        Edge Edge18 = new Edge('F', 'C', 11);
        Edge Edge19 = new Edge('F', 'E', 12);
        Edge Edge20 = new Edge('F', 'G', 8);
        Edge Edge21 = new Edge('G', 'E', 10);
        Edge Edge22 = new Edge('G', 'F', 8);

        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(Edge1);
        graph.add(Edge2);
        graph.add(Edge3);
        graph.add(Edge4);
        graph.add(Edge5);
        graph.add(Edge6);
        graph.add(Edge7);
        graph.add(Edge8);
        graph.add(Edge9);
        graph.add(Edge10);
        graph.add(Edge11);
        graph.add(Edge12);
        graph.add(Edge13);
        graph.add(Edge14);
        graph.add(Edge15);
        graph.add(Edge16);
        graph.add(Edge17);
        graph.add(Edge18);
        graph.add(Edge19);
        graph.add(Edge20);
        graph.add(Edge21);
        graph.add(Edge22);
        Prim pain = new Prim(graph, 'A');
        pain.minSpanTree();
    }
}
