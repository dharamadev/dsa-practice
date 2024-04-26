package com.techendear.string;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    public static void main(String[] args) {
        String str1 = "animalre";
        String str2 = "ainmaler";
        System.out.println("Is " + str1 + " and " + str2 + " Anagram:: " + checkAnagram(str1, str2));
    }

    private static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (count.containsKey(c) && count.get(c) > 0) {
                count.put(c, count.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
