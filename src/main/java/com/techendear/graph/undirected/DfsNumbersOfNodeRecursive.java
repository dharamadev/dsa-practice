package com.techendear.graph.undirected;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DfsNumbersOfNodeRecursive {
    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("J", "K"),
                Arrays.asList("I", "J"),
                Arrays.asList("K", "L"),
                Arrays.asList("L", "M"),
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
        AtomicInteger count = new AtomicInteger(0);
        Set<String> visited = new HashSet<>();
        graphVertx.forEach(val -> {
            if (countGraph(graph, val, visited)) {
                count.getAndIncrement();
            }
        });
        System.out.println("Total connected graph count :: "+count.get());
    }

    private static void getAdjList(Map<String, Set<String>> graph, List<List<String>> edges) {
        edges.forEach(value -> {
            if (!graph.containsKey(value.get(0))) graph.put(value.get(0), new HashSet<>());
            if (!graph.containsKey(value.get(1))) graph.put(value.get(1), new HashSet<>());
            graph.get(value.get(0)).add(value.get(1));
            graph.get(value.get(1)).add(value.get(0));
        });
    }

    private static Boolean countGraph(Map<String, Set<String>> graph, String current, Set<String> visited) {
        if (visited.contains(current)) return false;
        visited.add(current);
        for (String neigh : graph.get(current)) {
            countGraph(graph, neigh, visited);
        }
        return true;
    }
}
