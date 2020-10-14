package algorithm.stackAndQueue.book;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/30
 */

public class StackSort {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()){

            //用curr来存储每次从stack中pop出来的值
            int curr = stack.pop();

            while (!help.empty()&&help.peek()>curr){
                stack.push(help.pop());
            }

            help.push(curr);
        }

        while (!help.empty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(0);
        stack.push(1);
        stack.push(7);
        stack.push(4);

        sortStackByStack(stack);
//        for (int i : stack   ) {
//            System.out.println(i);
//        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
