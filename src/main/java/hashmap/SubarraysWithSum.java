package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int len = A.length;
        ArrayList<Integer> count = new ArrayList<>();
        int ans = 0;
        count.add(0);
        for (int i=1; i<=len; ++i) {
            count.add(count.get(i-1)+A[i-1]);
        }

        HashMap<Integer, Integer> c = new HashMap<>();
        for (int x: count) {
            ans += c.getOrDefault(x, 0);
            c.put(S+x, c.getOrDefault(x+S, 0)+1);
        }

        System.out.println(ans);
        return ans;
    }
}
