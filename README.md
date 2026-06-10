# Java Logistics Route Simulator

![Language](https://img.shields.io/badge/Language-Java-orange) ![Algorithms](https://img.shields.io/badge/Algorithms-Graph%2FDijkstra-blue) ![License](https://img.shields.io/badge/License-MIT-yellow) ![Status](https://img.shields.io/badge/Status-Active-brightgreen)

## Overview

Java console application that models a logistics delivery network as a weighted directed graph. Uses Dijkstra's algorithm and BFS to find optimal routes between cities, calculate total distances, and simulate delivery scheduling. Demonstrates core data structures and algorithm design applied to a real-world logistics scenario.

## Features

- Weighted directed graph implementation from scratch
- Dijkstra's shortest path algorithm for route optimization
- BFS for connectivity checking and unweighted traversal
- City/node management with distance-weighted edges
- Console menu for interactive route queries
- Delivery time estimation based on distance and speed parameters
- Export route summary to text report

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Java 17 |
| Data Structures | Custom Graph (Adjacency List) |
| Algorithms | Dijkstra, BFS, DFS |
| Build Tool | Maven |
| IDE | IntelliJ IDEA / Eclipse |
| Testing | JUnit 5 |

## Project Structure

```
java-logistics-route-simulator/
├── src/
│   ├── main/java/com/nikoandes/logistics/
│   │   ├── Main.java              # Entry point & console menu
│   │   ├── graph/
│   │   │   ├── Graph.java            # Adjacency list graph
│   │   │   ├── Node.java             # City node
│   │   │   └── Edge.java             # Weighted edge
│   │   ├── algorithms/
│   │   │   ├── Dijkstra.java         # Shortest path
│   │   │   └── BFS.java              # Breadth-first search
│   │   └── model/
│   │       ├── City.java             # City data model
│   │       └── Route.java            # Route result model
│   └── test/java/com/nikoandes/logistics/
│       └── DijkstraTest.java
├── pom.xml
├── .gitignore
├── LICENSE
└── README.md
```

## How to Run

### Prerequisites
- Java 17+
- Maven 3.8+

### Build and Run
```bash
git clone https://github.com/NikoAndes/java-logistics-route-simulator.git
cd java-logistics-route-simulator
mvn clean package
java -jar target/logistics-simulator.jar
```

### Sample Usage
```
=== Logistics Route Simulator ===
1. Add city
2. Add route (edge)
3. Find shortest path
4. Show all routes
5. Export report
0. Exit

Select option: 3
From city: Bogota
To city: Medellin

Shortest path: Bogota -> Manizales -> Medellin
Total distance: 423 km
Estimated time: 5.2 hours
```

## Algorithm Overview

| Algorithm | Use Case | Time Complexity |
|-----------|----------|-----------------|
| Dijkstra | Shortest delivery path | O((V+E) log V) |
| BFS | Connectivity check | O(V+E) |
| DFS | All-paths exploration | O(V+E) |

## What I Learned

- Implementing graph data structures from scratch in Java
- Dijkstra's algorithm with a priority queue (min-heap)
- Object-oriented design patterns for graph modeling
- Maven project structure and dependency management
- Writing unit tests for algorithmic correctness with JUnit 5
- Applying theoretical algorithms to real logistics problems

## Future Improvements

- [ ] Add GUI with JavaFX for visual route display
- [ ] Load city network from JSON/CSV file
- [ ] Implement A* algorithm for heuristic optimization
- [ ] Multi-vehicle routing problem (VRP) simulation
- [ ] Integrate with map data (OpenStreetMap)
- [ ] Add time windows and delivery scheduling constraints

## Author

**Nicolas Isaza Sierra** — [GitHub @NikoAndes](https://github.com/NikoAndes)

Mechatronics engineering student | Java & algorithms enthusiast | UMNG, Colombia

## License

MIT License — see [LICENSE](LICENSE) for details.
