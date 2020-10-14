package algorithm.tree.leetcode;
import	java.util.List;
import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/23
 */

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;
    }


    //注意，这里要用ArrayDeque的addLast和removeLast方法
    //不能用push和pop方法，ArrayDeque的push的pop是addFirst和removeFirst
    //因为这个题解中要用到ArrayDeque从头到尾构建路径，如果用push，pop会导致顺序不对
    public void pathSum(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res){
        // 递归终止条件
        if (node == null){
            return;
        }
        //沿途节点必须选择，这个时候要做两个事情：
        //1.sum减去这个节点的值
        //2.将这个节点加到path
        sum -= node.val;
        path.addLast(node.val);

        if (sum == 0 && node.left == null && node.right == null){
            res.add(new LinkedList<>(path));
            //必须要清空到最后一个节点，这样才能回溯
            path.removeLast();
            return;
        }

        pathSum(node.left, sum, path, res);
        pathSum(node.right, sum, path, res);
        //每次递归结束也都必须要清空最后一个节点，这样才能回溯
        path.removeLast();
    }



    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        List<List<Integer>> list = new ArrayList<> ();
        list.add(new ArrayList<>(queue));//可以用collection来创建List


        System.out.println(list);//居然可以这样打印list

    }
}
