package algorithm.stackAndQueue.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/21
 */

public class isValid20 {
    private HashMap<Character,Character> map;

    public isValid20(){
        this.map = new HashMap<Character, Character>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char a = s.charAt(i);
            if(this.map.containsKey(a)){
                char topElement = stack.empty() ? '!': stack.pop();
                if(topElement != this.map.get(a)){
                    return false;
                }
            }else{
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }
}
