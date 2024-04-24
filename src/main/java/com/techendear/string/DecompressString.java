package com.techendear.string;

public class DecompressString {
    public static void main(String[] args) {
        String str = "1a3b4c7d9x0v";
        String result = decompress(str);
        System.out.println(result);
    }

    private static String decompress(String str) {
        String nums = "1234567890";
        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = 0;

        while (end < str.length()) {
            String chare = String.valueOf(str.charAt(end));
            if (nums.contains(chare)) {
                end++;
            } else {
                int num = Integer.parseInt(str.substring(start, end));
                res.append(chare.repeat(num));
                end++;
                start = end;
            }
        }
        return res.toString();
    }

}
