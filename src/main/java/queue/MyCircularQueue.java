package queue;

import java.util.LinkedList;
import java.util.Queue;

class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(int val) {
        this.value = val;
        this.next = null;
    }
}

public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int max_size = 0;
    private LinkedNode curr;
    private Queue<LinkedNode> q = new LinkedList<>();

    public MyCircularQueue(int k) {
        if (k <= 0) {
            System.out.print("not supported length <= 0!");
        }
        this.max_size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        try {
            if (q.size() == 0) {
                curr = new LinkedNode(value);
                curr.next = curr;
                q.offer(curr);
            } else if (q.size() <= max_size - 1) {
                LinkedNode tmp = curr.next;
                curr.next = new LinkedNode(value);
                curr = curr.next;
                curr.next = tmp;
                q.offer(curr);
            } else {
                System.out.print("the queue is full");
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        try {
            if (q.size() == 0) {
                System.out.print("queue is empty");
                return false;
            } else {
                LinkedNode tmp = q.poll();
                curr.next = tmp.next;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return curr.next.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.curr.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return q.size() == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return q.size() == max_size;
    }
}
