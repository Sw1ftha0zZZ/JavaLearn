package algorithm.tree.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/12
 */

public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        int ans = Integer.MAX_VALUE;

        int pre = -1;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                if (pre == -1) {
                    pre = temp.val;
                }else {
                    ans = Math.min(Math.abs(pre - temp.val), ans);
                    pre = temp.val;
                }

                temp = temp.right;
            }
        }

        return ans;
    }
}
