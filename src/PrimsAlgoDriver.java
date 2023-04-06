import java.util.ArrayList;

public class PrimsAlgoDriver {
    public static void main(String[] args){
        Node node1 = new Node("A", "B", 9);
        Node node2 = new Node("A", "D", 15);
        Node node3 = new Node("A", "E", 20);
        Node node4 = new Node("B", "C", 17 + 9);
        Node node5 = new Node("B", "D", 7 + 9);
        Node node6 = new Node("C", "D", 14 + 16);
        Node node7 = new Node("C", "F", 11 + 17 + 9);
        Node node8 = new Node("D", "E", 5 + 15);
        Node node9 = new Node("E", "F", 12 + 20);
        Node node10 = new Node("E", "G", 10 + 20);
        Node node11 = new Node("F", "G", 8 + 20 + 12);

        ArrayList<Node> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        graph.add(node6);
        graph.add(node7);
        graph.add(node8);
        graph.add(node9);
        graph.add(node10);
        graph.add(node11);
        PrimsAlgo prim = new PrimsAlgo(graph, "A");
        prim.minimumSpanningTree();
    }
}
