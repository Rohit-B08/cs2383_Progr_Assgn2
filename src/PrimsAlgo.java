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

        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Node> temp = new ArrayList<>();
        String currentEdge = "";
        int counter = 0;
        boolean breakWhile = false;
        currentEdge = startingEdge;
        while(counter < graph.size()) {
            boolean added = false;
            for(Node edge : graph) {
                if(edge.getSource().equalsIgnoreCase(currentEdge)) {
                    boolean visit = false;
                    for(Node vst : visited) {
                        if(vst.getSource().equalsIgnoreCase(edge.getSource()) && vst.getDestination().equalsIgnoreCase(edge.getDestination())) {
                            visit = true;
                        }
                    }
                    if(!visit) {
                        temp.add(edge);
                        added = true;
//                    visited.add(edge.getSource());
                        counter++;
                    }
                    else {
                        currentEdge = edge.getSource();
                        breakWhile = true;
                    }
                }

            }

                if (!added) {
                    for (Node edge : graph) {
                        if (edge.getDestination().equalsIgnoreCase(currentEdge)) {
                            temp.add(edge);

//                    visited.add(edge.getSource());
                            counter++;
                        }
                    }
                }
                int min = 0;

                for (Node edge : temp) {
                    if (min == 0) {
                        min = edge.getWeight();
                        node = edge;
                    } else if (min > edge.getWeight()) {
                        min = edge.getWeight();
                        node = edge;
                    }
                }
                if (added) {
                    System.out.println(node);
                    visited.add(node);
                    currentEdge = node.getDestination();
                    temp.remove(node);
                } else {
                    System.out.println(node);
                    visited.add(node);
                    currentEdge = node.getSource();
                    temp.remove(node);
                }
            }

    }
}
