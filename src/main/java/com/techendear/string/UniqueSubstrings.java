package com.techendear.string;

public class UniqueSubstrings {
    public static void main(String[] args) {
        String str = "abacbdc";
        int res = uniqueSubstring(str);
        System.out.println(res);
    }

    private static int uniqueSubstring(String str) {
        int start = 0;
        int end = 0;
        int res = 1;
        while (end < str.length()) {
            if (str.substring(start, end).contains(String.valueOf(str.charAt(end)))) {
                res += 1;
                start = end;
            }
            end++;
        }
        return res;
    }
}
