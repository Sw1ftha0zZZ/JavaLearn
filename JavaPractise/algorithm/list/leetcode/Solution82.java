package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/03
 */

public class Solution82 {
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int flag = 0;
        ListNode temp1 = dummy;
        ListNode temp2 = dummy.next;

        while (temp1.next != null){
            while (temp2.next != null && temp2.val == temp2.next.val){
                temp2 = temp2.next;
                flag = 1;
            }
            if(flag == 1){
                temp1.next = temp2.next;
                temp2 = temp2.next;
                flag = 0;
            }else {
                temp1 = temp1.next;
                if(temp2.next != null){
                    temp2 = temp2.next;
                }
            }

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);



        ListNode result = deleteDuplicates(head);



        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }
}
