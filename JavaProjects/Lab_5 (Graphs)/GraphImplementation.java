public class GraphImplementation {
    
    public static void main(String[] args) {
        Graph ourGraph = new Graph(7);

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");

        Vertex[] vertex = {A, B, C, D, E, F, G};

        for (Vertex v : vertex) {
            ourGraph.AddVertex(v);
        }

        // D - центр
        ourGraph.AddEdge(D, A, 1);
        ourGraph.AddEdge(D, B, 1);
        ourGraph.AddEdge(D, C, 1);
        ourGraph.AddEdge(D, E, 1);
        ourGraph.AddEdge(D, F, 1);
        ourGraph.AddEdge(D, G, 1);
        
        // A - 4 связи, кроме D
        ourGraph.AddEdge(A, B, 1);
        ourGraph.AddEdge(A, C, 1);
        ourGraph.AddEdge(A, E, 1);
        ourGraph.AddEdge(A, F, 1);

        // G - 4 связи, кроме D
        ourGraph.AddEdge(G, B, 1);
        ourGraph.AddEdge(G, C, 1);
        ourGraph.AddEdge(G, E, 1);
        ourGraph.AddEdge(G, F, 1);

        // B - C - F
        ourGraph.AddEdge(C, B, 1);
        ourGraph.AddEdge(C, F, 1);

        // B - E - F
        ourGraph.AddEdge(E, B, 1);
        ourGraph.AddEdge(E, F, 1);

        
        ourGraph.printAdjMatrixOfGraph();
    }
}
