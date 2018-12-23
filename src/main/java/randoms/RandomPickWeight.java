package randoms;

import java.util.TreeMap;
import java.util.Random;

public class RandomPickWeight {
    private Random rand;
    private TreeMap<Integer, Integer> map;
    private int sum;

    public RandomPickWeight(int[] w) {
        rand = new Random();
        map = new TreeMap<>();
        sum = 0;
        for (int i=0; i<w.length; ++i) {
            map.put(sum, i);
            sum += w[i];
        }
    }

    public int pickIndex() {
        int key = (int) (sum * rand.nextFloat()); // Note: not rand.nextInt(sum+1)
        return map.floorEntry(key).getValue();
    }
}
