package algorithm.string.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/19
 */

public class Solution844 {
    /**
     * 双指针
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public boolean backspaceCompare1(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();

        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (int i = 0; i < sLen; i++) {
            if (S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            }else {
                if (stack1.isEmpty()) {
                    continue;
                }else {
                    stack1.pop();
                }
            }
        }

        for (int j = 0; j < tLen; j++) {
            if (T.charAt(j) != '#') {
                stack2.push(T.charAt(j));
            }else {
                if (stack2.isEmpty()) {
                    continue;
                }else {
                    stack2.pop();
                }
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            Character c1 = stack1.pop();
            Character c2 = stack2.pop();

            if (!c1.equals(c2)) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }
}
