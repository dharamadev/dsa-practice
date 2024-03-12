package com.techendear.array.matrix;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}};
        System.out.println(matrixDiagonalSum(mat));
    }

    private static int matrixDiagonalSum(int[][] mat) {
        int j = mat.length;
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        for (int i = 0; i < mat.length; i++) {
            sumDiag1 += mat[i][i];
            if (i != (j - i - 1))
                sumDiag2 += mat[i][j - i - 1];
        }
        return sumDiag1 + sumDiag2;
    }
}
