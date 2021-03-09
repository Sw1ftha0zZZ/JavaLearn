package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/03
 */

public class Solution61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int i = 0; i < k%length; i++){
            ListNode temp1 = dummy;
            ListNode temp2 = dummy.next;

            while (temp2.next != null){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            temp1.next = null;
            temp2.next = dummy.next;
            dummy.next = temp2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);



        ListNode result = rotateRight(head,6);



        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }


}
