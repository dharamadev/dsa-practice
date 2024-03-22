package com.techendear.graph.undirected;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BfsAllPathsToDestination {

    public static void main(String[] args) {
        int[][] adj = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        System.out.println(adj.length);
        List<List<Integer>> res= new ArrayList<>();
        dfs(adj, 4, 0, res);
        System.out.println(res);
    }

    private static void dfs(int[][] adj, int end, int start, List<List<Integer>> res) {
        List<Integer> tmp = new ArrayList<>();
        if(start==end) return;
        tmp.add(start);
        for(int val: adj[start]) {
            tmp.add(val);
            dfs(adj, end, val, res);
        }
        res.add(tmp);
    }
}
