package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/30
 *
 */

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null && rightNode == null){
            return null;
        }
        if (leftNode == null){
            return rightNode;
        }
        if (rightNode == null){
            return leftNode;
        }
        return root;
    }
}
