public class GraphImplementation {
    
    public static void main(String[] args) {
        Graph ourGraph = new Graph(6);

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");

        Vertex[] vertex = {A, B, C, D, E, F};

        for (Vertex v : vertex) {
            ourGraph.AddVertex(v);
        }

        ourGraph.AddEdge(B, A, 1);
        ourGraph.AddEdge(B, C, 1);
        ourGraph.AddEdge(B, D, 1);
        ourGraph.AddEdge(B, E, 1);

        ourGraph.AddEdge(E, C, 1);
        ourGraph.AddEdge(E, D, 1);
        ourGraph.AddEdge(E, F, 1);

        
        ourGraph.printGraph();
        ourGraph.printAdjMatrixOfGraph();
        if (ourGraph.isCyclic()) {
            System.out.println("Граф цикличен");
        }
        else {
            System.out.println("Граф не цикличен");
        }
    }
}
