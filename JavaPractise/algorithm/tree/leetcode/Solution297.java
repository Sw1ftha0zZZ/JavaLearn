package algorithm.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/27
 *
 * 用!表示一个值的结束
 * 用#表示这个节点为空
 *
 * 这个解法是用先序遍历实现的
 * Solution449是用层序遍历实现的
 */

public class Solution297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#!";
        }

        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);

        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; ++i) {
            queue.offer(values[i]);
        }
        return helper(queue);
    }

    public TreeNode helper(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = helper(queue);
        head.right = helper(queue);

        return head;
    }
}
