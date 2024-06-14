package com.techendear.graph.undirected;

import java.util.*;

public class CountConnectedComponents {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        );
        System.out.println(graph);
        int max = 0;
        Set<Integer> vis = new HashSet<>();
        for (Integer ode : graph.keySet()) {
            max = Math.max(max, countConnected(graph, ode, vis));
        }
        System.out.println("Max:: " + max);
    }

    private static int countConnected(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> vis) {
        if (node == null) return 0;
        if (vis.contains(node)) return 0;
        int count = 1;
        vis.add(node);
        for (Integer n : graph.get(node)) {
            if (!vis.contains(n)) {
                count += countConnected(graph, n, vis);
                vis.add(n);
            }
        }
        return count;
    }
}
