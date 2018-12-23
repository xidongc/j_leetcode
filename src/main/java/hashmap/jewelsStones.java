package hashmap;

import java.util.HashMap;

public class jewelsStones {
    public int numJewelsInStones(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        int result = 0;

        HashMap<Character, Integer> maps = new HashMap<>();
        for (char j : jewels) {
            maps.put(j, 0);
        }

        for (char s : stones) {
            if (maps.containsKey(s)) {
                maps.put(s, maps.get(s)+1);
            }
        }

        for (char key: maps.keySet()) {
            result += maps.get(key);
        }
        return result;
    }
}
