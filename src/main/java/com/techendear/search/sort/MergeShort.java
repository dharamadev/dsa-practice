package com.techendear.search.sort;

public class MergeShort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 9, 1, 6, 8, 7, 10, -1};
        sort(arr, arr.length);
        for (int j : arr) System.out.print(j + " ");
    }

    private static void sort(int[] a, int n) {
        if (n < 2) return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);
        sort(l, mid);
        sort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }


    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
