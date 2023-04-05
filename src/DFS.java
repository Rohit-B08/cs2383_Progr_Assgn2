// DFS algorithm in Java

import java.util.*;

public class DFS {

    public static void search(Vertex start, int total) {
        Set<Vertex> alreadyVisited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();

        stack.push(start);
        Vertex currentVertex;
        System.out.print("Visiting ");

        while (!stack.isEmpty() && alreadyVisited.size() < total) {
            currentVertex = stack.pop();
            System.out.print(" -> " + currentVertex.getName());

            if (!alreadyVisited.contains(currentVertex)) {
//                System.out.println(alreadyVisited.size());
                alreadyVisited.add(currentVertex);
                for (Vertex v : currentVertex.getNeighbours()) {
                    if (!alreadyVisited.contains(v)) {
//                        System.out.print(" Adding " + v.getName());
                        stack.push(v);
                    }
                }
            }
        }
    }


    public static void main(String args[]) {

        System.out.println("Graph 1 (not including back tracking)");
        // Make the vertices For 1.2 part 1
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

        DFS.search(vA, 7);

        System.out.println("\n\nGraph 2 (not including back tracking)");

        // Make the vertices for 1.2 part 2
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

        DFS.search(vA2, 6);
    }
}