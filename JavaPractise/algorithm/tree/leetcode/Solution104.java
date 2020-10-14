package algorithm.tree.leetcode;


import javafx.util.Pair;

import java.util.Stack;


/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/09
 */

public class Solution104 {

    //递归 DFS
    //时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)
    //空间复杂度：在最糟糕的情况下，树是完全不平衡的，
    //例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度）
    //因此保持调用栈的存储将是O(N)。
    //但在最好的情况下（树是完全平衡的），树的高度将是log(N)。
    //因此，在这种情况下的空间复杂度是 O(log(N))
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftLength = maxDepth(root.left);
            int rightLength = maxDepth(root.right);
            return Math.max(leftLength, rightLength) + 1;
        }
    }


    //迭代
    //使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
    //从包含根结点且相应深度为 1 的栈开始。然后我们继续迭代：
    //将当前结点弹出栈并推入子结点。每一步都会更新深度。
    //用到了Pairs来记录每个点处的深度是多少
    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<> (root, 1));

        int length = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode temp = pair.getKey();
            int currLen = pair.getValue();


            if (temp != null){
                length = Math.max(length, currLen);
                stack.push(new Pair<> (temp.left, currLen + 1));
                stack.push(new Pair<>(temp.right, currLen + 1));
            }

        }
        return length;
    }

}
