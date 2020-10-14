package algorithm.tree.book;
import	java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/29
 * 先序 中序 后序
 * 递归 非递归
 *
 */

public class Traversal {

    //非递归

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer> ();
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<> ();
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



    //递归

    public void preOrderRecursive(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public void inOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }
        inOrderRecursive(root.left);
        System.out.println(root.val + " ");
        inOrderRecursive(root.right);
    }

    public void postOrderRecursive(TreeNode root){
        if (root == null){
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.val + " ");
    }


}
