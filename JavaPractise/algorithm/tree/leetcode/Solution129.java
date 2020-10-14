package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/24
 */

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int num){
        if (root == null){
            return 0;
        }
        int sum = num * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }

        return helper(root.left, sum) + helper(root.right, sum);
    }
}
