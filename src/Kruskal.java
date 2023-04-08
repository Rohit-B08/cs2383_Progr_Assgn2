import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        Edge Edge1 = new Edge('A', 'B', 9);
        Edge Edge2 = new Edge('A', 'D', 15);
        Edge Edge3 = new Edge('A', 'E', 20);
        Edge Edge4 = new Edge('B', 'C', 17);
        Edge Edge5 = new Edge('B', 'D', 7);
        Edge Edge8 = new Edge('C', 'D', 14);
        Edge Edge9 = new Edge('C', 'F', 11);
        Edge Edge13 = new Edge('D', 'E', 5);
        Edge Edge16 = new Edge('E', 'F', 12);
        Edge Edge17 = new Edge('E', 'G', 10);
        Edge Edge19 = new Edge('F', 'E', 12);
        Edge Edge20 = new Edge('F', 'G', 8);
        int vertices = 7;

        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(Edge1);
        graph.add(Edge2);
        graph.add(Edge3);
        graph.add(Edge4);
        graph.add(Edge5);
        graph.add(Edge8);
        graph.add(Edge9);
        graph.add(Edge13);
        graph.add(Edge16);
        graph.add(Edge17);
        graph.add(Edge19);
        graph.add(Edge20);

        graph.sort(Comparator.comparingInt(o -> o.weight));
        minSpanTree(vertices, graph);
    }
}