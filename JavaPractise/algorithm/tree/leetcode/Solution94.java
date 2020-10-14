package algorithm.tree.leetcode;
import	java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/29
 * 中序遍历
 */

public class Solution94 {

    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }

        return list;
    }

    List<Integer> list = new ArrayList<Integer> ();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        inorderTraversal(root.left);

        list.add(root.val);

        inorderTraversal(root.right);

        return list;
    }
}
