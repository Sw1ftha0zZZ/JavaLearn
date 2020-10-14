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
 * 用层序遍历实现的
 *
 * 这个还和普通的层序遍历不一样，这个是入队的时候，就要把这个值写到string里面。
 * 而不是出队的时候再写到string里面
 *
 * 层序实现是没有用先序实现的效率高的
 */

public class Solution449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String res = root.val + "!";
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null){
                queue.offer(temp.left);
                res += temp.left.val + "!";
            }else {
                res += "#!";
            }


            if (temp.right != null){
                queue.offer(temp.right);
                res += temp.right.val + "!";
            }else {
                res += "#!";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("!");
        int index = 0;
        TreeNode node = buildTreeNode(values[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        if (node != null){
            queue.offer(node);
        }
        TreeNode temp = null;
        while (!queue.isEmpty()){
            temp = queue.poll();
            temp.left = buildTreeNode(values[index++]);
            temp.right = buildTreeNode(values[index++]);

            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return node;
    }

    public TreeNode buildTreeNode(String data){
        if (data.equals("#")){
            return null;
        }

        return new TreeNode(Integer.valueOf(data));
    }
}
