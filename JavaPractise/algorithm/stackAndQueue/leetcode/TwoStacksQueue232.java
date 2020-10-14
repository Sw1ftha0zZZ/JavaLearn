package algorithm.stackAndQueue.leetcode;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/25
 */

public class TwoStacksQueue232 {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue232(){
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void offer(int x){
        this.stackPush.push(x);
    }

    public int poll(){
        if(this.stackPush.isEmpty()&&this.stackPop.isEmpty()){
            throw new RuntimeException("Your Queue is empty");
        }else if(this.stackPop.isEmpty()){
            while(!this.stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.pop();
    }

    public int element(){
        if(this.stackPush.isEmpty()&&this.stackPop.isEmpty()){
            throw new RuntimeException("Your Queue is empty");
        }else if(this.stackPop.isEmpty()){
            while(!this.stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }

    public boolean empty(){
        return this.stackPop.empty()&&this.stackPush.empty();
    }
}
