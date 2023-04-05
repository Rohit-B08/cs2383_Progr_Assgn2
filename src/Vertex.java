import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Vertex {
    char name;
    Set<Vertex> neighbours;

    Vertex(char name) {
        this.name = name;
        this.neighbours = new HashSet<>();
//        System.out.println("Made a vertex " + name);
    }

    public void makeEdge(Vertex vertex) {
        this.neighbours.add(vertex);
        vertex.neighbours.add(this);
    }

    public char getName() {
        return this.name;
    }

    public Collection<? extends Vertex> getNeighbours() {
        return this.neighbours;
    }
}
