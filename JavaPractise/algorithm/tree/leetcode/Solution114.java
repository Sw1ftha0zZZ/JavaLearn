package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/27
 *
 *
 * 你最好去看看java的值传递，调用函数时，
 * 是在虚拟机栈的flatten方法创建的栈帧中的局部变量表里面
 * 复制一个在main方法的栈帧的局部变量表中的指向头结点的head引用
 * 你移动的一直都是flatten方法的头结点，
 * main方法里指向头结点一直都没移动，还是指向头结点，
 * 相当于你调用flatten方法就复制了一个引用也指向树的头结点，
 * 一直操作的是这个复制的，方法结束就销毁，原来在main方法里的还是没动
 *
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                //找到左子树最右的节点，并将右子树接到这个最右节点的右边
                pre.right = root.right;
                root.right = root.left;

                //这步是一定要做的
                root.left = null;
                root = root.right;
            }
        }
    }
}
