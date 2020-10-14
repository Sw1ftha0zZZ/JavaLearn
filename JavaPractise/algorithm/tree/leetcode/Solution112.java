package algorithm.tree.leetcode;
import	java.util.LinkedList;
import	java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/23
 */

public class Solution112 {

    //递归
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    //BFS，用两个队列实现
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        Queue<TreeNode> queNode = new LinkedList<TreeNode> ();
        Queue<Integer> queVal = new LinkedList<Integer> ();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {

            TreeNode temp = queNode.poll();
            int valTemp = queVal.poll();

            if (temp.left == null && temp.right == null){
                if (valTemp == sum){
                    return true;
                }
                continue;
            }


            if (temp.left != null){
                queNode.offer(temp.left);
                queVal.offer(valTemp + temp.left.val);
            }

            if (temp.right != null){
                queNode.offer(temp.right);
                queVal.offer(valTemp + temp.right.val);
            }

        }
        return false;
    }
}
