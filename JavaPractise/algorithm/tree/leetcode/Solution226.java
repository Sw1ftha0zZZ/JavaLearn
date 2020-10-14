package algorithm.tree.leetcode;
import	java.util.LinkedList;

import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/28
 */

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);

        return newNode;
    }

    //用队列实现
    //BFS
    public TreeNode invertTree1(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode tempRight = temp.right;
            temp.right = temp.left;
            temp.left = tempRight;
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        return root;
    }
}
