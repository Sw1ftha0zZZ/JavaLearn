package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/04
 *
 * 反转链表
 * 迭代6.4 + 递归6.28
 */

public class Solution206 {


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode before = null;
        ListNode temp = head;
        ListNode after = head;
        while (temp != null){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);


        ListNode result = reverseList(head);


        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }

    }

}
