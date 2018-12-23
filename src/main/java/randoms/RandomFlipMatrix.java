// reference: https://www.cnblogs.com/liaohuiqiang/p/9857273.html

package randoms;

import java.util.HashSet;
import java.util.LinkedHashMap;

// Sol-1 Fisher-Yates Shuffle
public class RandomFlipMatrix {
    private LinkedHashMap<Integer, Integer> dic = new LinkedHashMap<>();
    private int count;
    private int rows;
    private int cols;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        this.count = n_cols*n_rows;
        this.rows = n_cols;
        this.cols = n_rows;
    }

    public int[] flip() {
        this.count --;
        int index = (int)(Math.random()*(this.count));
        int ret = this.dic.computeIfAbsent(index, k->index);
        this.dic.put(index, this.dic.computeIfAbsent(this.count, k->this.count));
        return new int[]{ret/this.rows, ret%this.rows};
    }

    public void reset() {
        this.dic = new LinkedHashMap<>();
        this.count = this.cols * this.rows;
    }
}

// Reject Sampling
class RandomFlipMatrix2 {
    private HashSet<Integer> set = new HashSet<>();
    private int count;
    private int rows;
    private int cols;

    public RandomFlipMatrix2(int n_rows, int n_cols) {
        this.count = n_cols*n_rows;
        this.rows = n_cols;
        this.cols = n_rows;
    }

    public int[] flip() {
        int index = (int)(Math.random()*(this.count));
        while (set.contains(index)){
            index = (int)(Math.random()*(this.count));
        }
        set.add(index);
        return new int[]{index/this.rows, index%this.rows};
    }

    public void reset() {
        this.set = new HashSet<>();
        this.count = this.cols * this.rows;
    }
}
