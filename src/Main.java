import algorithm.Dijkstra;
import graph.Graph;

import java.util.Scanner;
import java.util.Set;

/**
 * Console interface for the Java Logistics Route Simulator.
 * Pre-loads a sample Colombian city network and finds optimal delivery routes.
 */
public class Main {

    public static void main(String[] args) {
        Graph network = buildColombiaNetwork();
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("   Java Logistics Route Simulator v1.0");
        System.out.println("============================================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> network.printGraph();
                case "2" -> findRoute(network, scanner);
                case "3" -> listCities(network);
                case "0" -> running = false;
                default  -> System.out.println("Invalid option.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Show road network");
        System.out.println("2. Find shortest route");
        System.out.println("3. List cities");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static void findRoute(Graph network, Scanner scanner) {
        System.out.print("Origin city     : ");
        String from = scanner.nextLine().trim();
        System.out.print("Destination city: ");
        String to = scanner.nextLine().trim();

        if (!network.hasCity(from) || !network.hasCity(to)) {
            System.out.println("One or both cities not found. Check spelling.");
            return;
        }

        Dijkstra.Result result = Dijkstra.shortestPath(network, from, to);
        System.out.println("\nShortest route: " + result);
    }

    private static void listCities(Graph network) {
        Set<String> cities = network.getCities();
        System.out.println("\nAvailable cities (" + cities.size() + "):");
        cities.forEach(c -> System.out.println("  - " + c));
    }

    /**
     * Builds a sample road network based on approximate distances
     * between major Colombian cities (in km by road).
     */
    private static Graph buildColombiaNetwork() {
        Graph g = new Graph();
        g.addRoad("Bogota",      "Medellin",    415);
        g.addRoad("Bogota",      "Cali",         462);
        g.addRoad("Bogota",      "Tunja",         147);
        g.addRoad("Bogota",      "Villavicencio",  86);
        g.addRoad("Medellin",    "Cali",          415);
        g.addRoad("Medellin",    "Manizales",     185);
        g.addRoad("Medellin",    "Monteria",      355);
        g.addRoad("Cali",        "Pasto",         456);
        g.addRoad("Cali",        "Pereira",       204);
        g.addRoad("Manizales",   "Pereira",        54);
        g.addRoad("Manizales",   "Ibague",        150);
        g.addRoad("Ibague",      "Bogota",        200);
        g.addRoad("Tunja",       "Bucaramanga",   195);
        g.addRoad("Bucaramanga", "Cucuta",        197);
        g.addRoad("Bucaramanga", "Barrancabermeja", 120);
        g.addRoad("Barranquilla","Cartagena",     120);
        g.addRoad("Barranquilla","Santa Marta",    90);
        g.addRoad("Monteria",    "Barranquilla",  355);
        return g;
    }
}
