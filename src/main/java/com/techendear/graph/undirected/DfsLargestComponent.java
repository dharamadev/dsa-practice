package com.techendear.graph.undirected;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DfsLargestComponent {

    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("J", "K"),
                Arrays.asList("I", "J"),
                Arrays.asList("K", "L"),
                Arrays.asList("L", "M"),
                Arrays.asList("M", "N"),
                Arrays.asList("L", "K"),
                Arrays.asList("P", "Q"),
                Arrays.asList("U", "F"),
                Arrays.asList("V", "")
        );
        Map<String, Set<String>> graph = new HashMap<>();
        getAdjList(graph, edges);
        Set<String> graphVertx = new HashSet<>();
        graph.forEach((key, value) -> {
            graphVertx.add(key);
            graphVertx.addAll(value);
        });
        AtomicInteger largest = new AtomicInteger();
        Set<String> visited = new HashSet<>();
        graphVertx.forEach(vertx -> {
            largest.set(Math.max(countGraph(graph, vertx, visited), largest.get()));
        });
        System.out.println("Size of largest graph::" + graph + "::::" + largest);
    }

    private static void getAdjList(Map<String, Set<String>> graph, List<List<String>> edges) {
        edges.forEach(value -> {
            if (!graph.containsKey(value.get(0))) graph.put(value.get(0), new HashSet<>());
            if (!graph.containsKey(value.get(1))) graph.put(value.get(1), new HashSet<>());
            graph.get(value.get(0)).add(value.get(1));
            graph.get(value.get(1)).add(value.get(0));
        });
    }

    private static Integer countGraph(Map<String, Set<String>> graph, String current, Set<String> visited) {
        if (visited.contains(current)) return 1;
        visited.add(current);
        int count = 0;
        for (String neigh : graph.get(current)) {
            count += countGraph(graph, neigh, visited);
        }
        return count;
    }

}
