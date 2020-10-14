package algorithm.tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/29
 */

public class Solution145 {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }


    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null){return list;}
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode temp = root;
        while (!stack1.isEmpty()){
            temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null){
                stack1.push(temp.left);
            }
            if (temp.right != null){
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }



}
