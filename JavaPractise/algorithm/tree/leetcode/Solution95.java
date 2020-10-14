package algorithm.tree.leetcode;
import	java.util.LinkedList;


import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/16
 */

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new LinkedList<TreeNode> ();
        }else {
            return helper(1, n);
        }
    }
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> result = new LinkedList<TreeNode> ();
        if (start > end){
            result.add(null);
            return result;
        }

        //不要忘了这个等号
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);


            for (TreeNode l : leftTree){
                for (TreeNode r : rightTree){
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = l;
                    currRoot.right = r;
                    result.add(currRoot);
                }
            }

        }

        return result;
    }
}
