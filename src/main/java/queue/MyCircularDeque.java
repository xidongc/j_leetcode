package queue;

import java.util.Deque;
import java.util.LinkedList;

class DoublyLinkedNode {

    int val;
    DoublyLinkedNode before;
    DoublyLinkedNode after;

    DoublyLinkedNode(int val) {
        this.val = val;
        this.before = null;
        this.after = null;
    }
}

public class MyCircularDeque {
    private int max_size;
    private Deque<DoublyLinkedNode> q = new LinkedList<>();
    private DoublyLinkedNode curr;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.max_size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (q.size() == 0) {
            curr = new DoublyLinkedNode(value);
            curr.before = curr;
            curr.after = curr;
            q.offerFirst(curr);
        } else if (q.size() < this.max_size) {
            DoublyLinkedNode tmp = curr.before;
            DoublyLinkedNode newValue = new DoublyLinkedNode(value);
            curr.before = newValue;
            newValue.after = curr;
            tmp.after = newValue;
            newValue.before = tmp;
            curr = newValue;
            q.offerFirst(newValue);
        } else {
            return false;
        }
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (q.size() == 0) {
            curr = new DoublyLinkedNode(value);
            curr.after = curr;
            curr.before = curr;
            q.offerLast(curr);
        } else if (q.size() < this.max_size) {
            DoublyLinkedNode tmp = curr.after;
            DoublyLinkedNode newValue = new DoublyLinkedNode(value);
            curr.after = newValue;
            newValue.before = curr;
            newValue.after = tmp;
            tmp.before = newValue;
            curr = newValue;
            q.offerLast(newValue);
        } else {
            return false;
        }
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.q.size() == 0) {
            return false;
        } else {
            DoublyLinkedNode ele = this.q.pollFirst();
            curr.after = ele.after;
            ele.after.before = curr;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (q.size() == 0) {
            return false;
        } else {
            DoublyLinkedNode ele = q.pollLast();
            curr = curr.before;
            curr.after = ele.after;
            curr.after.before = curr;
            return true;
        }

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (q.size() == 0) {
            return -1;
        }
        return q.peekFirst().val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (q.size() == 0) {
            return -1;
        }
        return q.peekLast().val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return q.size() == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return q.size() == this.max_size;
    }
}
