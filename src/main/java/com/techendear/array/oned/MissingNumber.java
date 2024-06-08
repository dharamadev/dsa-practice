package com.techendear.array.oned;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println("Sum:: " + missingNum(arr));
    }

    private static int missingNum(int[] arr) {
        int n = arr.length + 1;
        int sum = 0;
        int numSum = (n * (n + 1)) / 2;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(numSum + "::" + sum);
        return numSum - sum;
    }
}
