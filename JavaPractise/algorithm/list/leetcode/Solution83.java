package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/03
 */

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {



        ListNode temp1 = head;
        ListNode temp2 = temp1;

        while (temp1 != null) {
            while (temp2.next != null && temp2.val == temp2.next.val) {
                temp2 = temp2.next;
            }
            temp1.next = temp2.next;
            temp2 = temp2.next;
            temp1 = temp2;
        }


        return head;


    }
}
