package algorithm.stackAndQueue.leetcode;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/22
 *
 *                                  **平均时间复杂度还是O(1)的**
 */

class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty queue");
        }else if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty queue");
        }else if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPop.empty() && stackPush.empty();
    }
}