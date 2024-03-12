package com.techendear.graph.directed;

import java.util.*;

public class BfsFindPathIterative {

    public static void main(String[] args) {
        Map<String, List<String>> adj = new HashMap<>();
        adj.put("a", Arrays.asList("b", "c"));
        adj.put("b", List.of("d"));
        adj.put("c", List.of("e"));
        adj.put("d", List.of("f"));
        adj.put("e", List.of());
        adj.put("f", List.of());
        adj.put("g", List.of("c"));
        Queue<String> queue = new LinkedList<>();
        String start = "a";
        String end = "f";
        System.out.println(dfs(adj, start, end, queue));
    }

    private static boolean dfs(Map<String, List<String>> adj, String start, String dest, Queue<String> queue) {
        if (Objects.equals(dest, start)) return Boolean.TRUE;
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (Objects.equals(dest, current)) return Boolean.TRUE;
            queue.addAll(adj.get(current));
        }
        return Boolean.FALSE;
    }
}
