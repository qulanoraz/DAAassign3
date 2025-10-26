# City Transportation Network Optimization (MST)

## Project Overview

This project implements and compares two Minimum Spanning Tree (MST) algorithms — **Prim’s** and **Kruskal’s** — to optimize a city’s transportation network by connecting all districts with the minimal total road construction cost.

The project reads graphs from JSON files representing city districts and potential roads, runs both algorithms on each graph, measures execution time and operation counts, and writes results to `output.json`.

---

## Features

- Reads input graph data from JSON (`data/graphs.json`)
- Implements Prim’s algorithm using adjacency lists and a priority queue
- Implements Kruskal’s algorithm using edge list and union-find
- Measures execution time (in milliseconds) and counts core algorithm operations
- Outputs detailed MST edges, total cost, and performance data in JSON format (`output.json`)
- Java 24 compatible with Maven build (`pom.xml` included)

---

## Project Structure

transportMST/

│

├── data/

│ └── graphs.json # Input graph dataset

│

├── src/

│ ├── algorithms/

│ │ ├── KruskalAlgorithm.java

│ │ └── PrimAlgorithm.java

│ │

│ ├── io/

│ │ └── GraphReader.java

│ │

│ ├── model/

│ │ ├── Edge.java

│ │ ├── Graph.java

│ │ ├── GraphData.java

│ │ └── (result data classes)

│ │

│ └── analysis/

│ └── AlgorithmComparator.java # main class to run algorithms

│

├── output.json # Auto-generated results file

└── pom.xml # Maven build and dependencies


---

## How to Run

1. Build with Maven:
   
mvn clean compile


2. Run main class:

mvn exec:java -Dexec.mainClass="analysis.AlgorithmComparator"

3. Check output in `output.json`.

---

## Results Summary

| Graph ID | Algorithm | Execution Time (ms) | Operations Count | MST Total Cost |
|----------|-----------|--------------------|------------------|----------------|
| 1        | Prim      | 1.52               | 42               | 16             |
| 1        | Kruskal   | 1.28               | 37               | 16             |
| 2        | Prim      | 0.87               | 29               | 6              |
| 2        | Kruskal   | 0.92               | 31               | 6              |

---

## Algorithm Comparison

- **Prim’s algorithm** works better for dense graphs using adjacency lists.
- **Kruskal’s algorithm** is typically faster for sparse graphs using edge lists and union-find.
- Implementation complexity: Prim’s requires a priority queue, Kruskal’s needs careful union-find management.
- Both algorithms produced correct MST solutions with the same cost.

---

## Conclusion

For transportation networks resembling sparse graphs, Kruskal’s algorithm is preferable due to simpler implementation and efficient edge sorting. Prim’s algorithm is more suitable for dense graphs.

This project helped me understand MST concepts, algorithm performance measurement, and working with JSON data in Java.

---

## References

- [GeeksforGeeks: Prim’s Algorithm for MST](https://www.geeksforgeeks.org/dsa/prims-minimum-spanning-tree-mst-greedy-algo-5/)
- [GeeksforGeeks: Kruskal’s MST Algorithm](https://www.geeksforgeeks.org/dsa/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/)
- [Baeldung: Prim’s and Kruskal’s implementations in Java](https://www.baeldung.com/java-prim-algorithm)
- Official Java Documentation
