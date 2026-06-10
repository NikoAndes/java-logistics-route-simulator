package graph;

import java.util.*;

/**
 * Undirected weighted graph using adjacency list representation.
 * Models cities as nodes and road distances as edges.
 */
public class Graph {
    private final Map<String, List<Edge>> adjacency;

    public Graph() {
        this.adjacency = new LinkedHashMap<>();
    }

    public void addCity(String name) {
        adjacency.putIfAbsent(name, new ArrayList<>());
    }

    public void addRoad(String from, String to, int distanceKm) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, distanceKm));
        adjacency.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(from, distanceKm));
    }

    public List<Edge> getNeighbors(String city) {
        return adjacency.getOrDefault(city, Collections.emptyList());
    }

    public Set<String> getCities() {
        return adjacency.keySet();
    }

    public boolean hasCity(String name) {
        return adjacency.containsKey(name);
    }

    public void printGraph() {
        System.out.println("\n--- Network Map ---");
        for (Map.Entry<String, List<Edge>> entry : adjacency.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(e -> System.out.print(e.getTo() + "(" + e.getWeight() + "km) "));
            System.out.println();
        }
    }

    /** Represents a directed edge in the graph. */
    public static class Edge {
        private final String to;
        private final int weight;

        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public String getTo()   { return to; }
        public int getWeight()  { return weight; }
    }
}
