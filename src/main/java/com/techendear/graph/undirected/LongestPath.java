package com.techendear.graph.undirected;

import java.util.*;

public class LongestPath {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", List.of("b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        graph.put("b", List.of("c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        graph.put("c", List.of("d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        graph.put("d", List.of("e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        graph.put("e", List.of("f", "g", "h", "i", "j", "k", "l", "m", "n", "o"));
        graph.put("f", List.of("g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"));
        graph.put("g", List.of("h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"));
        graph.put("h", List.of("i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"));
        graph.put("i", List.of("j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t"));
        graph.put("j", List.of("k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"));
        graph.put("k", List.of("l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"));
        graph.put("l", List.of("m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y"));
        graph.put("m", List.of("n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x"));
        graph.put("n", List.of("o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        graph.put("o", List.of("p", "q", "r", "s", "t", "u", "v", "w", "x"));
        graph.put("p", List.of("q", "r", "s", "t", "u", "v", "w", "x", "y"));
        graph.put("q", List.of("r", "s", "t", "u", "v", "w", "x", "y"));
        graph.put("r", List.of("s", "t", "u", "v", "w", "x", "y", "z"));
        graph.put("s", List.of("t", "u", "v", "w", "x", "y", "z"));
        graph.put("t", List.of("u", "v", "w", "x", "y", "z"));
        graph.put("u", List.of("v", "w", "x", "y", "z"));
        graph.put("v", List.of("w", "x", "y", "z"));
        graph.put("w", List.of("x", "y", "z"));
        graph.put("x", List.of("y", "z"));
        graph.put("y", List.of("z"));
        graph.put("z", List.of());

        Map<String, Integer> dist = new HashMap<>();
        for (String ele : graph.keySet()) {
            if (graph.get(ele).isEmpty()) {
                dist.put(ele, 0);
            }
        }
        for (String ele : graph.keySet()) {
            longestPath(graph, ele, dist);
        }
        System.out.println("Max Length::" + Collections.max(dist.values()));
    }

    public static int longestPath(Map<String, List<String>> graph, String current, Map<String, Integer> dist) {
        if (dist.containsKey(current)) return dist.get(current);
        int max = 0;
        for (String v : graph.get(current)) {
            int curr = longestPath(graph, v, dist);
            if (curr > max)
                max = curr;
        }
        dist.put(current, max + 1);
        return max + 1;
    }
}
