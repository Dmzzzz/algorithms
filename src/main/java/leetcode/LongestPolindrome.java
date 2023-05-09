package leetcode;

import java.util.*;

public class LongestPolindrome {


    public static void main(String[] args) {

        String str = "sdfsdabaff";

        System.out.println(longestPolindrome(str));

    }

    public static String longestPolindrome(String str) {
        String result = "";
        Map<Character, List<Integer>> charByIndexes = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charByIndexes.containsKey(currentChar)) {
                List<Integer> currentIndexes = charByIndexes.get(currentChar);
                for (int j = 0; j < charByIndexes.size() &&
                        i - currentIndexes.get(j) + 1 > result.length();
                     j++) {
                    String s = str.substring(currentIndexes.get(j), i + 1);
                    StringBuilder sb = new StringBuilder(s);
                    if (sb.reverse().toString().equals(s)) {
                        result = s;
                    }
                    currentIndexes.add(i);
                }

            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                charByIndexes.put(currentChar, list);
            }
        }
        return result;
    }
}