package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/23
 */

public class Solution203 {
    public static ListNode removeElements(ListNode head, int val) {


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == val){
                pre.next = temp.next;

            }else {
                pre = pre.next;

            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = removeElements(head, 6);
        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }

    }

}
