public class Node {
    private String source;
    private String destination;
    private int weight;

    public Node(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }


    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", weight=" + weight;
    }
}
