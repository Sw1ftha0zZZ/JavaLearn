package algorithm.stackAndQueue.book;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/25
 */

class StackReverse {

    public int getAndRemoveLastElement(Stack<Integer> stack){
        int top = stack.pop();
        if (stack.empty()){
            return top;
        }else {
           int result = getAndRemoveLastElement(stack);
           stack.push(top);
           return result;
        }
    }

    public void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }else {
            int ans = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(ans);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
//        for (Integer i:stack) {
//            System.out.println(i);
//        }
        StackReverse solution = new StackReverse();
        solution.reverse(stack);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}

