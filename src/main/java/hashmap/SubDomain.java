package hashmap;

import java.util.*;

public class SubDomain {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        TreeMap<String, Integer> helper = new TreeMap<>();
        for (String cp: cpdomains) {
            String[] tmp = cp.split(" ");
            if (tmp.length != 2) {
                System.out.println("Input has some wrong");
            } else {
                String[] subd = tmp[1].split("\\.");
                int i = 0;
                int len = subd.length;
                while (i < len) {
                    String[] t = Arrays.copyOfRange(subd, i, len);
                    String target = String.join(".", t);
                    helper.put(target, helper.computeIfAbsent(target, k -> 0) + Integer.valueOf(tmp[0]));
                    i++;
                }
            }
        }

        for (Map.Entry<String, Integer> entry: helper.entrySet()) {
            String tmp = String.valueOf(entry.getValue()).concat(" ").concat(entry.getKey());
            result.add(tmp);
        }
        return result;
    }
}
