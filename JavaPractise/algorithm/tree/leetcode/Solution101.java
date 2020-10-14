package algorithm.tree.leetcode;
import	java.util.LinkedList;

import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/09
 */

public class Solution101 {

    //递归
    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }

        //这句话必须这样写，递归中要写的是递归终止条件
        //你加上if(p.val == q.val){return true;}是肯定不对的，这样不是恒等了吗
        return p.val == q.val && check(p.left, q.right) && check(p.right,q.left);

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    //迭代
    public boolean isSymmetric1(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();

            if (temp1 == null && temp2 == null){
                continue;
            }

            if ((temp1 == null || temp2 == null) || (temp1.val != temp2.val)){
                return false;
            }

            queue.offer(temp1.left);
            queue.offer(temp2.right);

            queue.offer(temp1.right);
            queue.offer(temp2.left);

        }
        return true;
    }
}
