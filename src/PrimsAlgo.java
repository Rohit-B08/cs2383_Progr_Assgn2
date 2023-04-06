import java.util.ArrayList;

public class PrimsAlgo {
    private ArrayList<Node> graph;
    private String startingEdge;

    public PrimsAlgo(ArrayList<Node> graph, String startingEdge) {
        this.graph = graph;
        this.startingEdge = startingEdge;
    }

    public void minimumSpanningTree() {
        Node node = null;
        ArrayList<Node> temp = new ArrayList<>();
        String currentEdge = "";
        int counter = 0;
        currentEdge = startingEdge;
        while(counter < graph.size()) {

            for(Node edge : graph) {
                if(edge.getSource().equalsIgnoreCase(currentEdge)) {
                    temp.add(edge);
                    counter++;
                }
            }
            int min = 0;

            for(Node edge : temp){
                if(min == 0) {
                    min = edge.getWeight();
                    node = edge;
                }
                else if(min > edge.getWeight()) {
                    min = edge.getWeight();
                    node = edge;
                }
            }
            assert node != null;
            System.out.println(node);
            currentEdge = node.getDestination();
            temp.remove(node);
        }
    }
}