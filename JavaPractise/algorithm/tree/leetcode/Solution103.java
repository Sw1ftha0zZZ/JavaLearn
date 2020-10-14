package algorithm.tree.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/16
 *
 * 保存好层次信息，在奇数层的时候用尾插法，在偶数层的时候用头插法
 * level要声明在外面
 */

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int n = queue.size();
            //注意这个地方左边要写成LinkedList，不能用List，不然addFirst会编译不过
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < n; i++){
                TreeNode temp = queue.poll();
                if (level % 2 == 1){
                    list.addLast(temp.val);
                }else {
                    list.addFirst(temp.val);
                }
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }

            result.add(list);
            level++;
        }

        return result;
    }
}
