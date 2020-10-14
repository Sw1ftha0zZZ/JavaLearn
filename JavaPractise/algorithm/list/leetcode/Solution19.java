package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/05/30 2020/10/04
 */

public class Solution19 {

    //双指针遍历一次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }





    //遍历两次
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length==1){
            return null;
        }

        int cursor = length-n;

        if (cursor==0){
            ListNode result = head.next;
            return result;
        }else {
            temp = head;
            for (int i = 0; i < cursor-1; ++i) {
                temp = temp.next;
            }
            temp.next = temp.next.next;

            return head;
        }



    }







    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        //ListNode head = new ListNode(1);

        ListNode result = removeNthFromEnd1(head,4);



        while (result!= null){
            System.out.println(result.val);
            result = result.next;
        }


    }

}
