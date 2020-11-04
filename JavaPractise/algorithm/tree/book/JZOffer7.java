package algorithm.tree.book;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/28
 */

public class JZOffer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preLen - 1, inorder, 0, inLen - 1, map);
    }

    public TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int inIndex = map.get(preorder[preLeft]);

        TreeNode root = new TreeNode(preorder[preLeft]);

        root.left = helper(preorder, preLeft + 1, preLeft + inIndex - inLeft, inorder, inLeft, inIndex - 1, map);
        root.right = helper(preorder, preLeft + inIndex - inLeft + 1, preRight, inorder, inIndex + 1, inRight, map);
        return root;
    }
}
