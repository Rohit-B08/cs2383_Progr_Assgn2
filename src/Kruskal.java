import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {

    static class Edge {
        public char source;
        public char destination;
        public int weight;

        public Edge(char source, char destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public char getSource() {
            return source;
        }

        public char getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }

    private ArrayList<Edge> graph;

    public Kruskal(ArrayList<Edge> graph) {
        this.graph = graph;
    }

    public void sortGraph() {
        graph.sort(Comparator.comparingInt(o -> o.weight));
    }

    public void enqueue() {

    }

    //Function to check which value has the lowest weight
    public Edge peek() {
        int lowestWeight = Integer.MAX_VALUE;
        Edge lowest = null;

        for (Edge edge : graph) {
            if (lowestWeight == edge.weight && (lowest != null ? lowest.source : 0) < edge.source) {
                lowest = edge;
            } else if (lowestWeight > edge.weight) {
                lowestWeight = edge.weight;
                lowest = edge;
            }
        }
        return lowest;
    }

    public Edge dequeue() {
        Edge lowest = peek();

        for (int i = graph.indexOf(lowest) + 1; i < graph.size(); i++) {
            Edge current = graph.get(i);
            graph.set(i-1, current);
        }
        if (graph.size() > 1) {
            graph.remove(graph.size()-1);
        } else {
            graph = null;
        }
        return lowest;
    }

    public void minSpanTree() {
        ArrayList<Character> visited = new ArrayList<>();
        ArrayList<Character> toVisit = new ArrayList<>();

        for (Edge edge : graph) {
            toVisit.add(edge.source);
        }

        while (!toVisit.isEmpty()) {
            Edge removedEdge = dequeue();
            if (!visited.contains(removedEdge.source) && !visited.contains(removedEdge.destination)) {
                visited.add(removedEdge.source);
                visited.add(removedEdge.destination);
                toVisit.removeAll(Collections.singleton(removedEdge.source));
                toVisit.removeAll(Collections.singleton(removedEdge.destination));
            }
        }
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge('A', 'B', 9);
        Edge edge2 = new Edge('A', 'D', 15);
        Edge edge3 = new Edge('A', 'E', 20);
        Edge edge4 = new Edge('B', 'C', 17);
        Edge edge5 = new Edge('B', 'D', 7);
        Edge edge6 = new Edge('C', 'D', 14);
        Edge edge7 = new Edge('C', 'F', 11);
        Edge edge8 = new Edge('D', 'E', 5);
        Edge edge9 = new Edge('E', 'F', 12);
        Edge edge10 = new Edge('E', 'G', 10);
        Edge edge11 = new Edge('F', 'G', 8);

        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(edge1);
        graph.add(edge2);
        graph.add(edge3);
        graph.add(edge4);
        graph.add(edge5);
        graph.add(edge6);
        graph.add(edge7);
        graph.add(edge8);
        graph.add(edge9);
        graph.add(edge10);
        graph.add(edge11);

        Kruskal pain = new Kruskal(graph);
        pain.minSpanTree();
    }
}


