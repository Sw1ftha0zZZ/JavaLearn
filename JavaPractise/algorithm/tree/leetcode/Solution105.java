package algorithm.tree.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/19
 */

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen){
            throw new RuntimeException("Error!");
        }
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < inLen; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preLen - 1,
                    inorder, 0, inLen - 1, map);
    }

    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight,
                           Map<Integer, Integer> map){
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.left = helper(preorder, preLeft + 1, preLeft + index - inLeft,
                            inorder, inLeft, index - 1,
                            map);
        root.right = helper(preorder, preLeft + index - inLeft + 1, preRight,
                            inorder, index + 1, inRight,
                            map);
        return root;
    }
}
