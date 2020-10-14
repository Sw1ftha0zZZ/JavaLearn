package algorithm.stackAndQueue.book;

import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/25
 */

public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue(){
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public void offer(int x){
        stackPush.push(x);
    }

    public int poll(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty queue");
        }else if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int element(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("empty queue");
        }else if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }



    public boolean empty(){
        return stackPop.empty() && stackPush.empty();
    }
}
