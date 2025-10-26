package model;

public class GraphResult {
    public int graph_id;
    public InputStats input_stats;
    public AlgorithmResult prim;
    public AlgorithmResult kruskal;

    public GraphResult(int id, InputStats stats, AlgorithmResult primR, AlgorithmResult kruskalR) {
        this.graph_id = id;
        this.input_stats = stats;
        this.prim = primR;
        this.kruskal = kruskalR;
    }
}
