package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/27
 */

public class Solution143 {
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode temp1 = null;
        ListNode temp2;
        while (temp != null) {
            temp2 = temp.next;
            temp.next = temp1;
            temp1 = temp;
            temp = temp2;
        }

        return temp1;
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode rightReverse = reverse(right);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode leftTemp = head;
        ListNode rightTemp = rightReverse;
        while (leftTemp != null && rightTemp != null){
            temp.next = leftTemp;
            leftTemp = leftTemp.next;
            temp = temp.next;
            temp.next = rightTemp;
            rightTemp = rightTemp.next;
            temp = temp.next;
        }
        temp.next = leftTemp;

    }
}
