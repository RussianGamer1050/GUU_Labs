// import java.util.HashSet;
import java.util.ArrayList;

class Graph {
    private ArrayList<Vertex> nodes; // set (теперь массив) узлов графа
    private boolean[][] adjMatrix;


    public Graph(int numVertices) {
        nodes = new ArrayList<>();

        adjMatrix = new boolean[numVertices][numVertices];
    }


    public boolean AddVertex(Vertex v) {
        return nodes.add(v);
    }

    public boolean AddEdge(Vertex v1, Vertex v2, int weight) {
        adjMatrix[nodes.indexOf(v1)][nodes.indexOf(v2)] = true;
        adjMatrix[nodes.indexOf(v2)][nodes.indexOf(v1)] = true;
        
        return (v1.getEdges().add(new Edge(v2, weight))) && (v2.getEdges().add(new Edge(v1, weight)));
    }


    public void printGraph() {
        for (Vertex v : nodes) {
            System.out.println("vertex name: " + v.getName() + ": ");
            for (Edge e : v.getEdges()) {
                System.out.println("destVertex: " + e.getDestVertex().getName()
                + " weight: " + e.getWeight() + " | ");
            }
            System.out.println("\n");
        }
    }

    public void printAdjMatrixOfGraph() {
        int k = 0;
        // Шапка матрицы
        System.out.print("    ");
        for (Vertex v : nodes) {
            System.out.print(v.getName() + " ");
        }
        System.out.println();

        for (boolean[] row : adjMatrix) {
            System.out.print(nodes.get(k++).getName() + " | ");
            for (boolean i : row) {
                if (i == true) {
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("|");
        }
    }
}
