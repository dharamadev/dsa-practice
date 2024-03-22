package com.techendear.graph.undirected;

import java.util.*;

public class BfsDungeonExitProblem {
    public static void main(String[] args) {
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 5),
                Arrays.asList(5, 8),
                Arrays.asList(2, 6),
                Arrays.asList(5, 6)
        );

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i <= 3; i++) {
            if (!adj.containsKey(edges.get(i).get(0))) adj.put(edges.get(i).get(0), new ArrayList<>());
            if (!adj.containsKey(edges.get(i).get(1))) adj.put(edges.get(i).get(1), new ArrayList<>());
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        adj.entrySet().forEach(System.out::println);
        List<Integer> res = new ArrayList<>();
        dfs(adj, new LinkedList<>(), 0, 6, res);
        System.out.println(res);
    }

    private static void dfs(Map<Integer, List<Integer>> adj, Queue<Integer> visited, int start, int end, List<Integer> result) {
        if (Objects.equals(start, end)) return;
        result.add(start);
        visited.add(start);
        for (int ed : adj.get(start)) {
            if (!visited.contains(ed)) {
                dfs(adj, visited, ed, end, result);
            }
        }
    }
}
