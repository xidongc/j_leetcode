package hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class Pattern {
    private HashMap<Character, String> match = new HashMap<>();
    private HashSet<String> set = new HashSet<>();

    public boolean wordPattern(String pattern, String str) {
        String[] value = str.split(" ");
        char[] pat = pattern.toCharArray();

        if (pat.length != value.length) {
            return false;
        }

        int i = 0;
        for (Character p: pat) {
            String tmp = value[i];
            String val = match.computeIfAbsent(p, k->
            {
                if (set.contains(tmp)) {
                    return "0";
                }
                return tmp;
            });
            if (!val.equals(tmp)) {
                return false;
            }
            set.add(tmp);
            ++ i;
        }
        return true;
    }
}
