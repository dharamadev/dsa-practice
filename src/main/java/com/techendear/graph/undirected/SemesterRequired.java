package com.techendear.graph.undirected;

import java.util.*;

public class SemesterRequired {
    public static void main(String[] args) {
        List<List<Integer>> prereqs = List.of(
                List.of(1, 2),
                List.of(2, 4),
                List.of(3, 5),
                List.of(0, 5)
        );
        Map<Integer, List<Integer>> graph = getGraph(prereqs);
        System.out.println("Graph:: " + graph);
        Map<Integer, Integer> dist = new HashMap<>();
        for (Integer ele : graph.keySet()) {
            if (graph.get(ele).isEmpty()) {
                dist.put(ele, 0);
            }
        }
        for (Integer ele : graph.keySet()) {
            getDuration(graph, ele, dist);
        }
        System.out.println("Semester count:: " + Collections.max(dist.values()));
    }

    private static Map<Integer, List<Integer>> getGraph(List<List<Integer>> prereqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        prereqs.forEach(v -> {
            if (!graph.containsKey(v.get(0))) graph.put(v.get(0), new ArrayList<>());
            if (!graph.containsKey(v.get(1))) graph.put(v.get(1), new ArrayList<>());
            graph.get(v.get(0)).add(v.get(1));
        });
        return graph;
    }

    private static int getSemCount(Map<Integer, List<Integer>> graph, Integer current, Map<Integer, Integer> duration) {
        if (duration.containsKey(current)) return duration.get(current);
        int max = 1;
        for (Integer cur : graph.get(current)) {
            int val = getSemCount(graph, cur, duration);
            if (val > max) {
                max = val;
            }
        }
        duration.put(current, max + 1);
        return max + 1;
    }

    private static int getDuration(Map<Integer, List<Integer>> graph, Integer curr, Map<Integer, Integer> dur) {
        if (dur.containsKey(curr)) return dur.get(curr);
        int max = 1;
        for (Integer node : graph.get(curr)) {
            int count = getDuration(graph, node, dur);
            if (count > max) {
                max = count;
            }
        }
        dur.put(curr, max + 1);
        return max + 1;
    }
}
