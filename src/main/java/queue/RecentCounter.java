package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> q;

    public RecentCounter() {
        this.q = new LinkedList<>();
    }

    public int ping(int t) {
        while (q.size() > 0 && t - q.peek() > 3000) {
            q.poll();
        }
        q.offer(t);
        return q.size();
    }
}
