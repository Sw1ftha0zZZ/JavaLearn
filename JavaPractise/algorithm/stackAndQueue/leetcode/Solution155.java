package algorithm.stackAndQueue.leetcode;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/22
 */

class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        if(stackMin.isEmpty() || x <= stackMin.peek()){

            stackMin.push(x);

        }

        stackData.push(x);
    }

    public void pop() {
        if(stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else{
            int value = stackData.pop();
            if(value == getMin()){
                stackMin.pop();
            }

        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else{
            return stackMin.peek();
        }
    }
}
