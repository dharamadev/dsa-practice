package com.techendear.graph.undirected;

import java.util.List;
import java.util.Objects;

public class NumberOfIsland {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );
        System.out.println(islandCount(grid));
    }

    public static int islandCount(List<List<String>> grid) {
        // todo
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j] != 1 && grid.get(i).get(j).equals("L")) {
                    count+=1;
                    dfs(grid, i, j, n, m, vis);
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
        return count;
    }

    private static boolean safe(int i, int j, int n, int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }
    private static void dfs(List<List<String>> grid, int i, int j, int n, int m, int[][] vis) {
        if(Objects.equals(grid.get(i).get(j), "W")) return;
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vis[i][j] = 1;
        for(int k=0; k<4; k++) {
            int newi = i+move[k][0];
            int newj = j+move[k][1];
            if(safe(newi, newj, n, m) && grid.get(newi).get(newj).equals("L") && vis[newi][newj] != 1) {
                vis[newi][newj] = 1;
                dfs(grid, newi, newj, n, m, vis);
            }
        }
    }
}
