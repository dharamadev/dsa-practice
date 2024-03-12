package com.techendear.graph.directed;

import java.util.*;

public class DfsTraversalIterative {
    public static void main(String[] args) {
        Map<String, List<String>> adj = new HashMap<>();
        adj.put("a", Arrays.asList("b", "c"));
        adj.put("b", List.of("d"));
        adj.put("c", List.of("e"));
        adj.put("d", List.of("f"));
        adj.put("e", List.of());
        adj.put("f", List.of());
        Stack<String> stack = new Stack<>();
        dfs(adj, "a", stack);
    }

    public static void dfs(Map<String, List<String>> adj, String start, Stack<String> stack) {
        stack.push(start);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println(current);
            for (String neigh : adj.get(current)) {
                stack.push(neigh);
            }
        }
    }
}

