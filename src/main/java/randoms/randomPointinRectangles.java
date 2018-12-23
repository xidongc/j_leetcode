package randoms;

import java.util.TreeMap;
import java.util.Random;

public class randomPointinRectangles {

    private Random rand = new Random();
    private int sum=0;
    private TreeMap<Integer, int[]> map = new TreeMap<>();

    public randomPointinRectangles(int[][] rects) {
        for (int[] rect: rects){
            if (rect.length == 4) {
                map.put(sum, rect);
                int diffX = Math.abs(rect[2] - rect[0]);
                int diffY = Math.abs(rect[3] - rect[1]);
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            }
        }
    }

    public int[] pick() {
        int index = (rand.nextInt(sum-1));
        int[] curr = map.floorEntry(index).getValue();
        int newX, newY;

        if (curr[2] == curr[0]){
            newX = curr[2];
        } else {
            newX = rand.nextInt(curr[2] - curr[0]+1) + curr[0];
        }
        if (curr[3] == curr[1]){
            newY = curr[3];
        } else {
            newY = rand.nextInt(curr[3] - curr[1]+1) + curr[1];
        }
        return new int[]{newX, newY};
    }
}
