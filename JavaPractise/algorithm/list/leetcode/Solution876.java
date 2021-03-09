package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/21
 */

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast.next != null){
            return slow.next;
        }else {
            return slow;
        }

    }
}
