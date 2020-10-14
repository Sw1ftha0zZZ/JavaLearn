package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/19
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDep = minDepth(root.left);
        int rightDep = minDepth(root.right);
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        if (root.left == null || root.right == null){
            return leftDep + rightDep + 1;
            //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        }
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(leftDep, rightDep) + 1;
    }
}
