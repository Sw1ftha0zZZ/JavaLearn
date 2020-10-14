package algorithm.stackAndQueue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * 用队列实现栈
 * @author xinghao
 * @date 2020/04/23
 */

class OneQueueStack225 {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public OneQueueStack225() {
        this.queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
        for(int i = 1; i < this.queue.size(); i++){
            this.queue.offer(this.queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return this.queue.element();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }

}