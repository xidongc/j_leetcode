package string;

import java.util.*;

public class LongestPalindromicSubstring {
    private HashMap<Character, HashSet<Integer>> index = new HashMap<>();

    public String longestPalindrome(String s) {
        // error handling
        if (s.length() <= 1) {
            return s;
        }
        // also some regex to rule out the possibility of invalid s input

        String longestLength = "";
        for (int i=0; i<s.length(); ++i) {
            HashSet<Integer> local = index.getOrDefault(s.charAt(i), new HashSet<Integer>());
            local.add(i);
            index.put(s.charAt(i), local);
        }

        // index {a: {0,2,4}, b: {1,3}}

        for (int j=0; j<s.length(); ++j) {
            if (index.containsKey(s.charAt(j)) && index.get(s.charAt(j)).size() >= 2) {
                for (int tmp: index.get(s.charAt(j))) {
                    if (tmp+1-j>longestLength.length() && tmp > j && this.isPalindromic(s.substring(j, tmp+1))) {
                        longestLength = s.substring(j, tmp+1);
                    }
                }
            } else if (longestLength.length() == 0 && index.containsKey(s.charAt(j)) && index.get(s.charAt(j)).size() == 1) {
                longestLength = s.substring(j, j+1);
            }
        }
        return longestLength;
    }

    private boolean isPalindromic(String input) {
        if (input.length() == 0) {
            return true;
        }

        int startIndex = 0;
        int endIndex = input.length() - 1;

        while (startIndex < endIndex) {
            if (input.charAt(startIndex) == input.charAt(endIndex)) {
                startIndex ++;
                endIndex --;
            } else {
                return false;
            }
        }
        return true;
    }
}
