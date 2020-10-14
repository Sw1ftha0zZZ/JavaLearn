package algorithm.tree.leetcode;

import algorithm.list.leetcode.ListNode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/15
 */

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null){
            return null;
        }


        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode rightPart = mid.next;
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid){
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightPart);
        return root;
    }
}
