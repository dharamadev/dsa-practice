package com.techendear.array.matrix;

public class MatrixSpiralTraversal {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        printBoundary(mat);
    }

    private static void printBoundary(int[][] mat) {
        int i = 0, j = 0;
        int len = mat.length - 1;
        for (j = 0; j < len; j++) {
            System.out.print(mat[i][j] + " ");
        }
        System.out.println();
        if (j == len) {
            for (i = 0; i < len; i++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
        if (i == len) {
            for (j = len; j > 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
        if (j == 0) {
            for (i = len; i > 0; i--) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}
