package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/05
 */

public class Solution100 {
    //递归，时间复杂度o（n），因为每个节点都要访问一次
    //空间复杂度最坏o（n）完全不平衡二叉树，最好情况下o（logn）完全平衡二叉树。这个是用来维护递归栈的
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null){
            return true;
        }
        //p或q为空
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //迭代，待补充

}
