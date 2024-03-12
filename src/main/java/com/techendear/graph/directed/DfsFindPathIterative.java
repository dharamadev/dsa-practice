package com.techendear.graph.directed;

import java.util.*;

public class DfsFindPathIterative {

    public static void main(String[] args) {
        Map<String, List<String>> adj = new HashMap<>();
        adj.put("a", Arrays.asList("b", "c"));
        adj.put("b", List.of("d"));
        adj.put("c", List.of("e"));
        adj.put("d", List.of("f"));
        adj.put("e", List.of());
        adj.put("f", List.of());
        adj.put("g", List.of("c"));
        Stack<String> stack = new Stack<>();
        String start = "g";
        String end = "c";
        System.out.println(dfs(adj, start, end, stack));
    }

    private static boolean dfs(Map<String, List<String>> adj, String start, String dest, Stack<String> stack) {
        if (Objects.equals(dest, start)) return Boolean.TRUE;
        stack.push(start);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (Objects.equals(dest, current)) return Boolean.TRUE;
            for (String neigh : adj.get(current)) {
                stack.push(neigh);
            }
        }
        return Boolean.FALSE;
    }
}
