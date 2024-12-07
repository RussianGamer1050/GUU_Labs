import java.util.ArrayList;
import java.util.LinkedList;

class Graph {
    private ArrayList<Vertex> nodes;
    private boolean[][] adjMatrix;


    public Graph(int numVertices) {
        nodes = new ArrayList<>();

        adjMatrix = new boolean[numVertices][numVertices];
    }

    public ArrayList<Vertex> getNodes() {
        return nodes;
    }

    // Добавление вершин графа
    public boolean AddVertex(Vertex v) {
        return nodes.add(v);
    }
    // Добавление ребер графа
    public boolean AddEdge(Vertex v1, Vertex v2, int weight) {
        adjMatrix[nodes.indexOf(v1)][nodes.indexOf(v2)] = true;
        adjMatrix[nodes.indexOf(v2)][nodes.indexOf(v1)] = true;
        
        return (v1.getEdges().add(new Edge(v2, weight))) && (v2.getEdges().add(new Edge(v1, weight)));
    }

    // Проверка на цикличность графа
    public boolean isCyclic() {
        ArrayList<Vertex> visited = new ArrayList<>();
        Vertex p = new Vertex("default parent");
        
        for (Vertex v : this.getNodes()) {
            if (!visited.contains(v)) {
                if (isCyclicUtil(v, v.getEdges(), visited, p)) {
                    return true;
                }
            }
        }
        return false;
    }
    // Вспомогательная рекурсивная функция для проверки цикличности
    public boolean isCyclicUtil(Vertex v, LinkedList<Edge> edges, ArrayList<Vertex> visited, Vertex parent) {
        visited.add(v); // cur == current

        for (Edge e : v.getEdges()) {
            if (!visited.contains(e.getDestVertex())) {
                if (isCyclicUtil(e.getDestVertex(), e.getDestVertex().getEdges(), visited, v)) {
                    return true;
                }
            }
            else if (!e.getDestVertex().equals(parent)) {
                return true;
            }
        }
        return false;
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
