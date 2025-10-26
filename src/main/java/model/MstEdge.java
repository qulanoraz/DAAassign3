package model;

import java.util.List;

public class MstEdge {
    public String from, to;
    public int weight;

    public MstEdge(String f, String t, int w) {
        this.from = f; this.to = t; this.weight = w;
    }
}
