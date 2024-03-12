package com.techendear.graph.undirected;

import java.util.*;

public class DfsUndirectedGraphIterative {
    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
                Arrays.asList("J", "K"),
                Arrays.asList("I", "J"),
                Arrays.asList("K", "L"),
                Arrays.asList("L", "M"),
                Arrays.asList("L", "K"),
                Arrays.asList("P", "Q")
        );
        Set<String> visited = new HashSet<>();
        Map<String, Set<String>> graph = new HashMap<>();
        buildGraph(edges, graph);
        System.out.println(graph);
        System.out.println(dfs(graph, "J", "Q", visited));
    }

    private static void buildGraph(List<List<String>> edges, Map<String, Set<String>> graph) {
        edges.forEach(value -> {
            if (!graph.containsKey(value.get(0))) {
                graph.put(value.get(0), new HashSet<>());
            }
            if (!graph.containsKey(value.get(1))) {
                graph.put(value.get(1), new HashSet<>());
            }
            graph.get(value.get(0)).add(value.get(1));
            graph.get(value.get(1)).add(value.get(0));
        });
    }

    private static Boolean dfs(Map<String, Set<String>> graph, String start, String end, Set<String> visited) {
        if (Objects.equals(start, end)) return true;
        if (visited.contains(start)) return false;
        visited.add(start);
        for (String neigh : graph.get(start)) {
            if (dfs(graph, neigh, end, visited)) return true;
        }
        return false;
    }
}
