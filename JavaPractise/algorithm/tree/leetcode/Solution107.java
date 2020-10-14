package algorithm.tree.leetcode;

import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/12
 */

public class Solution107 {

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {

        //注意这里等号左边要是LinkedList
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int n = queue.size();

            for (int i = 0; i < n; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.addFirst(list);//头插就可以了
        }

        return result;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int n = queue.size();

            for (int i = 0; i < n; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            temp.add(list);
        }
        ListIterator<List<Integer>> itr = temp.listIterator(temp.size());
        for (; itr.hasPrevious();){
            result.add(itr.previous());
        }
        return result;
    }
}
