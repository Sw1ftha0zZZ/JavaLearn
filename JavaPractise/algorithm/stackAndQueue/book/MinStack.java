package algorithm.stackAndQueue.book;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/23
 */

public class MinStack{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else{
            int value = this.stackData.pop();
            if(value==this.getMin()){
                this.stackMin.pop();
            }
            return value;
        }
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else{
            return this.stackMin.peek();
        }
    }


}