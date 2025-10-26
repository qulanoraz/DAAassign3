package model;

import java.util.List;

public class AlgorithmResult {
    public List<MstEdge> mst_edges;
    public int total_cost;
    public int operations_count;
    public double execution_time_ms;

    public AlgorithmResult(List<MstEdge> mstEdges, int cost, int ops, double timeMs) {
        this.mst_edges = mstEdges;
        this.total_cost = cost;
        this.operations_count = ops;
        this.execution_time_ms = timeMs;
    }
}
