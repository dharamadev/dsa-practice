package com.techendear.graph.directed;

import java.util.*;

public class DfshTraversalRecursive {
    public static void main(String[] args) {
        Map<String, List<String>> adj = new HashMap<>();
        adj.put("a", Arrays.asList("b", "c"));
        adj.put("b", List.of("d"));
        adj.put("c", List.of("e"));
        adj.put("d", List.of("f"));
        adj.put("e", List.of());
        adj.put("f", List.of());
        dfs(adj, "a");
    }

    public static void dfs(Map<String, List<String>> adj, String start) {
        if(start==null) return;
        System.out.println(start);
        for (String neigh : adj.get(start))
            dfs(adj, neigh);
    }
}

