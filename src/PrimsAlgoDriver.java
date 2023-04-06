import java.util.ArrayList;

public class PrimsAlgoDriver {
    public static void main(String[] args){
        Node node1 = new Node("A", "B", 3);
        Node node2 = new Node("A", "D", 5);
        Node node3 = new Node("B", "C", 4);
        Node node4 = new Node("B", "E", 7);
        Node node5 = new Node("C", "F", 10);
        ArrayList<Node> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);
        PrimsAlgo prim = new PrimsAlgo(graph, "A");
        prim.minimumSpanningTree();
    }
}
