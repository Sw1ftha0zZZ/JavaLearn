package algorithm.tree.leetcode;
import	java.util.ArrayList;

import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/29
 */

public class Solution144 {

    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        List<Integer> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        return list;
    }


    List<Integer> list = new ArrayList<Integer> ();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
