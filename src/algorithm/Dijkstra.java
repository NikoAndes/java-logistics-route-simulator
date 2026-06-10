package algorithm;

import graph.Graph;

import java.util.*;

/**
 * Dijkstra's shortest-path algorithm for the logistics graph.
 * Returns the shortest path and total distance between two cities.
 */
public class Dijkstra {

    public static class Result {
        public final List<String> path;
        public final int totalDistance;

        public Result(List<String> path, int totalDistance) {
            this.path = path;
            this.totalDistance = totalDistance;
        }

        public boolean isReachable() { return !path.isEmpty(); }

        @Override
        public String toString() {
            if (!isReachable()) return "No route found.";
            return String.join(" -> ", path) + "  [" + totalDistance + " km]";
        }
    }

    /**
     * Finds the shortest path from source to destination.
     * @param graph the road network
     * @param source starting city
     * @param destination target city
     * @return Result containing path and distance
     */
    public static Result shortestPath(Graph graph, String source, String destination) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String city : graph.getCities()) dist.put(city, Integer.MAX_VALUE);
        dist.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            if (current.equals(destination)) break;

            for (Graph.Edge edge : graph.getNeighbors(current)) {
                int newDist = dist.get(current) + edge.getWeight();
                if (newDist < dist.getOrDefault(edge.getTo(), Integer.MAX_VALUE)) {
                    dist.put(edge.getTo(), newDist);
                    prev.put(edge.getTo(), current);
                    pq.remove(edge.getTo());
                    pq.add(edge.getTo());
                }
            }
        }

        // Reconstruct path
        List<String> path = new LinkedList<>();
        String step = destination;
        while (step != null) {
            path.add(0, step);
            step = prev.get(step);
        }

        if (!path.get(0).equals(source)) return new Result(Collections.emptyList(), -1);
        return new Result(path, dist.get(destination));
    }
}
