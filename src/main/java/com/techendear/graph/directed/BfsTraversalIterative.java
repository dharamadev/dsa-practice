package com.techendear.graph.directed;

import java.util.*;

public class BfsTraversalIterative {
    public static void main(String[] args) {
        Map<String, List<String>> adj = new HashMap<>();
        adj.put("a", Arrays.asList("b", "c"));
        adj.put("b", List.of("d"));
        adj.put("c", List.of("e"));
        adj.put("d", List.of("f"));
        adj.put("e", List.of());
        adj.put("f", List.of());
        Queue<String> stack = new LinkedList<>();
        bfs(adj, "a", stack);
    }

    public static void bfs(Map<String, List<String>> adj, String start, Queue<String> queue) {
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);
            queue.addAll(adj.get(current));
        }
    }
}

