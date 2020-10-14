package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/22
 */

public class Solution654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int l, int r){
        if (l > r){
            return null;
        }
        int maxIndex = max(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, l, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i <= r; i++) {
            if (nums[max_i] < nums[i]){
                max_i = i;
            }
        }
        return max_i;
    }


}
