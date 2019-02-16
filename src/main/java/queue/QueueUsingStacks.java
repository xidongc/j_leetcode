package queue;

import java.util.*;

public class QueueUsingStacks {
    /** Initialize your data structure here. */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    /* O(1) */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    /* O(n) */
    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int ret = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return ret;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int ret = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}
