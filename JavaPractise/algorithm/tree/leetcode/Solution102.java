package algorithm.tree.leetcode;
import	java.util.List;

import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/12
 */

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> list = new LinkedList<> ();
            for (int i = 0; i < n; i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }


        return result;

    }


}
