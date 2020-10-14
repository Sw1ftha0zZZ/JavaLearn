package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/28
 * leetcode 876（找中间结点） + leetcode 21（合并两个有序链表）
 */

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            //如果这样就不用排序了，返回head
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
//        ListNode pre = head;
//        while (fast != null && fast.next != null) {
//            pre = slow;
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        pre.next = null;
//
//        return merge(sortList(head), sortList(slow));

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(newHead));
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

}
