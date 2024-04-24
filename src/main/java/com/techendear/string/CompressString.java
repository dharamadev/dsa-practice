package com.techendear.string;

public class CompressString {

    public static void main(String[] args) {
        String str = "dddawwwlllvvhhhv";
        String res = compress(str);
        System.out.println("Compressed string:: " + res);
    }

    private static String compress(String str) {
        str += "!";
        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = 0;

        while (end < str.length()) {
            char st = str.charAt(start);
            char cur = str.charAt(end);
            if (st == cur) {
                end++;
            } else {
                int count = end - start;
                if (count > 1)
                    res.append(count).append(st);
                else
                    res.append(st);
                start = end;
            }
        }

        return res.toString();
    }
}
