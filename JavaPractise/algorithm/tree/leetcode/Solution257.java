package algorithm.tree.leetcode;
import java.util.LinkedList;
import	java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/31
 */

public class Solution257 {
    public void buildPath(TreeNode root, String path, List<String> paths) {
        if (root == null){
            return;
        }
        path += Integer.toString(root.val);
        if (root.left == null && root.right == null){
            paths.add(path);
            return;
        }else {
            path += "->";
            buildPath(root.left, path, paths);
            buildPath(root.right, path, paths);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        buildPath(root, "",paths);
        return paths;
    }


    public List<String> binaryTreePaths1(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null){
            return paths;
        }

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null)){
                paths.add(path);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }



}
