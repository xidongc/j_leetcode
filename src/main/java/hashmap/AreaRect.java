package hashmap;

import java.util.*;
import java.lang.Math;

public class AreaRect {

    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;
        TreeMap<Integer, ArrayList<Integer>> rows = new TreeMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();

        for (int[] point: points) {
            rows.computeIfAbsent(point[0], k->new ArrayList<>()).add(point[1]);
        }

        for (int x :rows.keySet()) {
            ArrayList<Integer> tmp = rows.get(x);
            Collections.sort(tmp);
            for (int i=0; i<tmp.size(); ++i) {
                for (int j=i+1; j<tmp.size(); ++j) {
                    int y1 = tmp.get(i);
                    int y2 = tmp.get(j);
                    Integer code = Hash(y1, y2);
                    if (cols.containsKey(code)) {
                        minArea = Math.min(minArea, Math.abs(x - cols.get(code)) * (y2-y1));
                    }
                    cols.put(code, x);
                }
            }
        }
        if (minArea == Integer.MAX_VALUE) {
            return 0;
        }
        return minArea;
    }

    // several LTE due to hash function
    private Integer Hash(Integer a, Integer b) {
        return 40001 * a + b;
    }
}
