package com.techendear.graph.undirected;

import java.util.*;

public class DfsShortestPath {
    public static void main(String[] args) {
        List<List<String>> edges = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        ); // ->  2
        System.out.println("Graph:: " + getGraph(edges));
        System.out.println("Distance between w and z :: " + shortestPath(getGraph(edges), new HashSet<>(), "w", "z"));

        System.out.println("===================================");
        List<List<String>> edges1 = List.of(
                List.of("a", "c"),
                List.of("a", "b"),
                List.of("c", "b"),
                List.of("c", "d"),
                List.of("b", "d"),
                List.of("e", "d"),
                List.of("g", "f")
        ); // -> 3
        System.out.println("Graph:: " + getGraph(edges1));
        System.out.println("Distance between a and e :: " + shortestPath(getGraph(edges1), new HashSet<>(), "a", "e"));
    }

    private static Map<String, List<String>> getGraph(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            if (!graph.containsKey(edge.get(0))) graph.put(edge.get(0), new ArrayList<>());
            if (!graph.containsKey(edge.get(1))) graph.put(edge.get(1), new ArrayList<>());
            graph.get(edge.get(1)).add(edge.get(0));
            graph.get(edge.get(0)).add(edge.get(1));
        }
        return graph;
    }

    private static int shortestPath(Map<String, List<String>> graph, Set<String> visited, String start, String end) {
        Queue<AbstractMap.SimpleEntry<String, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(start, 0));
        visited.add(start);
        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> data = q.poll();
            String node = data.getKey();
            Integer distance = data.getValue();
            if (node == end) return distance;
            for (String curr : graph.get(node)) {
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    q.add(new AbstractMap.SimpleEntry<>(curr, distance + 1));
                }
            }
        }
        return -1;
    }
}
