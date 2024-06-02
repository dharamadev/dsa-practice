package com.techendear.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class SmallestLand {

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        System.out.println("Min land::: " + minimumIsland(grid));
    }

    public static int minimumIsland(List<List<String>> grid) {
        int l = grid.size();
        int m = grid.get(0).size();
        int max = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[l][m];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                if(!vis[i][j] && grid.get(i).get(j).equals("L"))
                    max = Math.min(countNum(grid, i, j, l, m, vis), max);
            }
        }
        return max;
    }

    private static Boolean safe(int i, int j, int l, int m) {
        return i >= 0 && i < l && j >= 0 && j < m;
    }

    private static int countNum(List<List<String>> grid, int i, int j, int l, int m, boolean[][] vis) {
        int[][] move = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newi = i + move[k][0];
            int newj = j + move[k][1];
            if (safe(newi, newj, l, m) && !vis[newi][newj] && grid.get(newi).get(newj).equals("L")) {
                vis[newi][newj] = true;
                return 1 + countNum(grid, newi, newj, l, m, vis);
            }
        }
        return 1;
    }
}
