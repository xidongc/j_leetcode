package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> rel = new HashMap<>();
        HashSet<String> tmp = new HashSet<>();
        int size = s.length();
        for (int i = 0; i <= size-10; ++ i) {
            String key = s.substring(i, i+10);
            int value = rel.computeIfAbsent(key, k->0) + 1;
            rel.put(key, value);
            if (value > 1) {
                tmp.add(key);
            }
        }
        return new ArrayList<>(tmp);
    }
}
