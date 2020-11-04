package algorithm.tree.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/28
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    //next指针指向父节点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class JZOffer8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
         if (pNode == null) {
             return null;
         }
        // 若给定节点 有右子树， 则返回的一定是 右子树 最左边的节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
 
        // 若没有右子树 则返回的是 父亲节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) { // 父亲节点的左节点等于本身，且本身没有右节点，那么直接返回父节点
                return pNode.next;
            }
            pNode = pNode.next; // 父亲节点的左节点不等于本身，说明本身在父节点的右子节点，继续遍历父亲节点的父节点
        }
        return null;
    }
}