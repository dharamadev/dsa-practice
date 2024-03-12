package com.techendear.graph.undirected;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class DfsCountNodesConnectedComponent {
    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("J", "K"),
                Arrays.asList("I", "J"),
                Arrays.asList("K", "L"),
                Arrays.asList("L", "M"),
                Arrays.asList("L", "K"),
                Arrays.asList("P", "Q"),
                Arrays.asList("U", "F"),
                Arrays.asList("U", "V")
        );

        Map<String, Set<String>> graph = new HashMap<>();
        getAdjList(graph, edges);
        System.out.println("Graph :: " + graph);
        Set<String> nodes = new HashSet<>();
        edges.forEach(nodes::addAll);
        Set<String> visited = new HashSet<>();
        AtomicReference<Integer> longest = new AtomicReference<>(0);
        nodes.forEach(node -> {
            Integer size = countNode(graph, node, visited);
            if (size > longest.get()) longest.set(size);
        });
        System.out.println(longest.get());
    }

    private static Integer countNode(Map<String, Set<String>> graph, String node, Set<String> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);
        Integer size = 1;
        for (String neigh : graph.get(node)) {
            size += countNode(graph, neigh, visited);
        }
        return size;
    }

    private static void getAdjList(Map<String, Set<String>> graph, List<List<String>> edges) {
        edges.forEach(value -> {
            if (!graph.containsKey(value.get(0))) graph.put(value.get(0), new HashSet<>());
            if (!graph.containsKey(value.get(1))) graph.put(value.get(1), new HashSet<>());
            graph.get(value.get(0)).add(value.get(1));
            graph.get(value.get(1)).add(value.get(0));
        });
    }
}
