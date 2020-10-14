package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/18
 */

public class Solution110 {
    //自顶向下
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //自底向上
    public int recur(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = recur(root.left);
        if (left == -1){
            return -1;
        }
        int right = recur(root.right);
        if (right == -1){
            return - 1;
        }

        return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public boolean isBalanced1(TreeNode root){
        return recur(root) != -1;
    }
}
