package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/05/31
 */

public class Solution24 {
    public static ListNode swapPairs(ListNode head) {

        if(head == null||head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;

    }

    public static ListNode swapPairs1(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;


            prev = first;
            head = first.next;

        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);



        ListNode result = swapPairs(head);



        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }
}
