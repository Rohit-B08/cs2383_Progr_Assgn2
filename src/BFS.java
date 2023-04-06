// BFS algorithm in Java

import java.util.*;

public class BFS {

    public static void search(Vertex start) {
        Set<Vertex> alreadyVisited = new HashSet<>();

        Queue<Vertex> queue = new ArrayDeque<>();
        queue.add(start);
        Vertex currentVertex;
        System.out.print("Visiting ");

        while (!queue.isEmpty()) {
            currentVertex = queue.remove();
            System.out.print(" -> " + currentVertex.getName());

            if (!alreadyVisited.contains(currentVertex)) {
                alreadyVisited.add(currentVertex);
                queue.addAll(currentVertex.getNeighbours());
                queue.removeAll(alreadyVisited);
            }
        }
    }


    public static void main(String args[]) {

        System.out.println("Graph 1");
        // Make the vertices For 1.3 part 1
        Vertex vA = new Vertex('A');
        Vertex vB = new Vertex('B');
        Vertex vC = new Vertex('C');
        Vertex vD = new Vertex('D');
        Vertex vE = new Vertex('E');
        Vertex vF = new Vertex('F');
        Vertex vG = new Vertex('G');

        // Made the edges
        vA.makeEdge(vB);
        vA.makeEdge(vD);
        vB.makeEdge(vC);
        vB.makeEdge(vD);
        vC.makeEdge(vD);
        vC.makeEdge(vF);
        vD.makeEdge(vE);
        vE.makeEdge(vF);
        vF.makeEdge(vG);

        BFS.search(vA);

        System.out.println("\n\nGraph 2");

        // Make the vertices for 1.3 part 2
        Vertex vA2 = new Vertex('A');
        Vertex vB2 = new Vertex('B');
        Vertex vC2 = new Vertex('C');
        Vertex vD2 = new Vertex('D');
        Vertex vE2 = new Vertex('E');
        Vertex vF2 = new Vertex('F');

        // Made the edges
        vA2.makeEdge(vB2);
        vA2.makeEdge(vD2);
        vB2.makeEdge(vC2);
        vB2.makeEdge(vD2);
        vC2.makeEdge(vD2);
        vC2.makeEdge(vE2);
        vD2.makeEdge(vE2);
        vD2.makeEdge(vF2);

        BFS.search(vA2);
    }
}