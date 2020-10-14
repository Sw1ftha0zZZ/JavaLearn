package algorithm.tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/28
 */

public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;

    }
}
