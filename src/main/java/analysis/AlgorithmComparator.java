package analysis;

import algorithms.*;
import com.google.gson.Gson;
import io.*;
import model.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmComparator {
    public static void main(String[] args) {
        GraphData data = GraphReader.loadGraphs("data/graphs.json");
        List<GraphResult> results = new ArrayList<>();

        for (Graph g : data.graphs) {
            AlgorithmResult primRes = PrimAlgorithm.run(g);
            AlgorithmResult kruskalRes = KruskalAlgorithm.run(g);

            InputStats stats = new InputStats(g.nodes.size(), g.edges.size());

            GraphResult graphRes = new GraphResult(g.id, stats, primRes, kruskalRes);
            results.add(graphRes);
        }

        OutputData outputData = new OutputData(results);

        try (FileWriter writer = new FileWriter("output.json")) {
            new Gson().toJson(outputData, writer);
            System.out.println("Results saved to output.json");
        } catch (Exception e) {
            System.err.println("Failed to write output.json: " + e.getMessage());
        }
    }
}
