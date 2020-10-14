package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/30
 *
 * BST的性质：
 * 节点 N 左子树上的所有节点的值都小于等于节点 N 的值
 * 节点 N 右子树上的所有节点的值都大于等于节点 N 的值
 * 左子树和右子树也都是 BST
 *
 * 从根节点开始遍历树
 * 如果节点 p 和节点 q 都在右子树上，那么以右孩子为根节点继续 1 的操作
 * 如果节点 p 和节点 q 都在左子树上，那么以左孩子为根节点继续 1 的操作
 * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 p 和节点 q 的 LCA 了
 * --------------------------------------------------------------------
 *
 * 由于这个方法用BST的性质，不需要回溯，所以可以不用递归，也不用栈
 *
 */

public class Solution235 {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > rootVal && qVal > rootVal){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (pVal < rootVal && qVal < rootVal){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    //迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null){
            int nodeVal = node.val;
            if (pVal < nodeVal && qVal < nodeVal){
                node = node.left;
            }else if (pVal > nodeVal && qVal > nodeVal){
                node = node.right;
            }else {
                return node;
            }

        }
        return null;
    }
}
