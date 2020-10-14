package algorithm.tree.leetcode;
import	java.util.HashMap;
import	java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/19
 */

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int posLen = postorder.length;
        if (inLen != posLen){
            throw new RuntimeException("Error!");
        }
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inLen - 1, postorder, 0, posLen - 1, map);
    }

    public TreeNode helper(int[] inorder, int inLeft, int inRight,
                           int[] postorder, int postLeft, int postRight,
                           Map<Integer, Integer> map){
        if (inLeft > inRight || postLeft > postRight){
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = helper(inorder, inLeft, index - 1,
                            postorder, postLeft, postLeft + index - inLeft - 1,
                            map);
        root.right = helper(inorder, index + 1, inRight,
                            postorder, postLeft + index - inLeft, postRight - 1,
                            map);
        return root;
    }
}
