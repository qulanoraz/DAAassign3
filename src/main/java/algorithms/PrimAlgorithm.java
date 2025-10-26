package algorithms;

import model.*;
import java.util.*;

public class PrimAlgorithm {
    public static AlgorithmResult run(Graph g) {
        long start = System.nanoTime();
        Map<String, List<Edge>> adj = new HashMap<>();
        for (String node : g.nodes) adj.put(node, new ArrayList<>());

        for (Edge e : g.edges) {
            adj.get(e.from).add(e);
            adj.get(e.to).add(new Edge(){{
                from = e.to; to = e.from; weight = e.weight;
            }});
        }

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<MstEdge> mst = new ArrayList<>();
        int cost = 0, operations = 0;

        String startNode = g.nodes.get(0);
        visited.add(startNode);
        pq.addAll(adj.get(startNode));

        while (!pq.isEmpty() && mst.size() < g.nodes.size() - 1) {
            Edge edge = pq.poll();
            operations++;
            if (visited.contains(edge.to)) continue;
            visited.add(edge.to);
            mst.add(new MstEdge(edge.from, edge.to, edge.weight));
            cost += edge.weight;
            pq.addAll(adj.get(edge.to));
        }

        long end = System.nanoTime();
        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(mst, cost, operations, timeMs);
    }
}
