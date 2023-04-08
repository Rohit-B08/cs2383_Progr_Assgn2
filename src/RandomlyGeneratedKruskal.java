import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomlyGeneratedKruskal {

    static class Edge {
        public char source;
        public char destination;
        public int weight;

        public Edge(char source, char destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Subset {
        char parent;
        int rank;

        public Subset(char parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static void connect(ArrayList<Subset> subsets, char x, char y) {
        char rootX = findRoot(subsets, x);
        char rootY = findRoot(subsets, y);

        int indexX = 0, indexY = 0;
        for (int i = 0; i < subsets.size(); i++) {
            if (subsets.get(i).parent == rootX) {
                indexX = i;
            }
            if (subsets.get(i).parent == rootY) {
                indexY = i;
            }
        }

        if (subsets.get(indexY).rank < subsets.get(indexX).rank) {
            subsets.get(indexY).parent = rootX;
        } else if (subsets.get(indexY).rank > subsets.get(indexX).rank) {
            subsets.get(indexX).parent = rootY;
        } else {
            subsets.get(indexY).parent = rootX;
            subsets.get(indexX).rank++;
        }
    }

    public static char findRoot(ArrayList<Subset> subsets, char i) {
        if (subsets.get((int) i - 65).parent == i) {
            return subsets.get((int) i - 65).parent;
        }

        subsets.get((int) i - 65).parent = findRoot(subsets, subsets.get((int) i - 65).parent);

        return i;
    }

    public static void minSpanTree(int vertices, List<Edge> graph) {
        ArrayList<Edge> tree = new ArrayList<>();
        ArrayList<Subset> subsets = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            subsets.add(new Subset((char) (i+65), 0));
        }

        int j = 0, numberOfEdges = 0;
        while (numberOfEdges < vertices - 1) {
            Edge nextEdge = graph.get(j);
            char x = findRoot(subsets, nextEdge.source);
            char y = findRoot(subsets, nextEdge.destination);

            if (x != y) {
                tree.add(nextEdge);
                connect(subsets, x, y);
                numberOfEdges++;
            }
            j++;
        }

        System.out.println(
                "Following are the edges of the constructed minimum spanning tree:");
        int minCost = 0;
        for (int i = 0; i < numberOfEdges; i++) {
            System.out.println(tree.get(i).source + " -- " + tree.get(i).destination + " == " + tree.get(i).weight);
            minCost += tree.get(i).weight;
        }
        System.out.println("Total cost of tree: " + minCost);
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
                }
            }
        }

        graph.sort(Comparator.comparingInt(o -> o.weight));
        System.out.println("The graph list:");
        for (Edge edge : graph) {
            System.out.println(edge.source + ", " + edge.destination + ", " + edge.weight);
        }

        System.out.println("===================================================");
        System.out.println("Minimum spanning tree");
        double startTime = System.currentTimeMillis();
        minSpanTree(n, graph);
        double endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Execution time: " + (endTime - startTime));
    }
}
