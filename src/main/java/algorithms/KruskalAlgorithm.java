package algorithms;

import model.*;
import model.Graph;
import java.util.*;

public class KruskalAlgorithm {
    private static class DisjointSet {
        Map<String, String> parent = new HashMap<>();

        void makeSet(List<String> nodes) {
            for (String n : nodes) parent.put(n, n);
        }

        String find(String node) {
            if (!parent.get(node).equals(node))
                parent.put(node, find(parent.get(node)));
            return parent.get(node);
        }

        void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) parent.put(rootA, rootB);
        }
    }

    public static AlgorithmResult run(Graph g) {
        long start = System.nanoTime();
        DisjointSet ds = new DisjointSet();
        ds.makeSet(g.nodes);

        List<Edge> edges = new ArrayList<>(g.edges);
        edges.sort(Comparator.comparingInt(e -> e.weight));

        List<MstEdge> mst = new ArrayList<>();
        int cost = 0, operations = 0;

        for (Edge e : edges) {
            operations++;
            if (!ds.find(e.from).equals(ds.find(e.to))) {
                ds.union(e.from, e.to);
                mst.add(new MstEdge(e.from, e.to, e.weight));
                cost += e.weight;
            }
        }
        long end = System.nanoTime();

        double timeMs = (end - start) / 1e6;
        return new AlgorithmResult(mst, cost, operations, timeMs);
    }
}
