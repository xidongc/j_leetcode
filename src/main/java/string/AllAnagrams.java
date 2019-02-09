package string;

import java.util.*;

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ret = new ArrayList<>();
        // error handle
        if (s.length() == 0 || p.length() == 0) {
            return ret;
        }
        // init
        char[] inputData = s.toCharArray();
        char[] target = p.toCharArray();
        int windowSize = p.length();

        //counter
        HashMap<Character, Integer> count = new HashMap<>();
        for (char x: target) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // move window
        if (windowSize > inputData.length) {
            return ret;
        }

        HashMap<Character, Integer> cmp = new HashMap<>();

        for (char x: s.substring(0, windowSize).toCharArray()) {
            cmp.put(x, cmp.getOrDefault(x, 0) + 1);
        }

        if (cmp.equals(count)) {
            ret.add(0);
        }

        for (int i=windowSize; i<inputData.length; ++i) {
            cmp.put(inputData[i], cmp.getOrDefault(inputData[i], 0) + 1);
            cmp.put(inputData[i-windowSize], cmp.getOrDefault(inputData[i-windowSize], 1) - 1);
            if (cmp.get(inputData[i-windowSize]) == 0){
                cmp.remove(inputData[i-windowSize]);
            }
            if (cmp.equals(count)) {
                ret.add(i - windowSize + 1);
            }
        }
        return ret;
    }

}
