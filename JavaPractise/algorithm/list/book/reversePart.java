package algorithm.list.book;

import algorithm.list.leetcode.ListNode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/07
 *
 * 反转部分单向链表
 *
 */

public class reversePart {
    public static ListNode reversePart(ListNode head, int from, int to){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp1 = dummy;
        ListNode temp2 = dummy;

        for (int i = 1; i < from; i++){
            temp1 = temp1.next;
        }
        for (int i = 1; i <= to; i++){
            temp2 = temp2.next;
        }

        ListNode before = temp1;
        temp1 = temp1.next;
        ListNode prev = temp2.next;

        ListNode after = temp2.next;

        while (temp1 != after){
            ListNode currNext = temp1.next;
            temp1.next = prev;
            prev = temp1;
            temp1 = currNext;
        }
        before.next = temp2;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        ListNode result = reversePart(head,1,2);



        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }

}
