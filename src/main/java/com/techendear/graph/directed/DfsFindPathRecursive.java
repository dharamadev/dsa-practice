package com.techendear.graph.directed;

import java.util.*;

public class DfsFindPathRecursive {

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
        String start = "a";
        String end = "f";
        System.out.println(dfs(adj, start, end));
    }

    public static Boolean dfs(Map<String, List<String>> adj, String start, String destination) {
        if (Objects.equals(start, destination)) return true;

        for (String curr : adj.get(start)) {
            if (dfs(adj, curr, destination)) return true;
        }
        return false;
    }
}
