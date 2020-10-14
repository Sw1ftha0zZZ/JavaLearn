package algorithm.tree.leetcode;

import	java.util.ArrayDeque;

import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/16
 */

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        double pre = - Double.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode> ();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                if (temp.val <= pre){
                    return false;
                }
                pre = temp.val;
                temp = temp.right;
            }
        }
        return true;
    }

    public boolean helper(TreeNode node, Integer lowwer, Integer upper){
        if (node == null){
            return true;
        }
        int value = node.val;
        if (lowwer != null && lowwer >= value){
            return false;
        }
        if (upper != null && upper <= value){
            return false;
        }
        if (!helper(node.left, lowwer, value)){
            return false;
        }
        if (!helper(node.right, value, upper)){
            return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }


}
