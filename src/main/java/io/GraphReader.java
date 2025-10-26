package io;
import com.google.gson.Gson;
import java.io.FileReader;
import model.GraphData;

public class GraphReader {
    public static GraphData loadGraphs(String path) {
        try (FileReader reader = new FileReader(path)) {
            return new Gson().fromJson(reader, GraphData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
