package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/23
 */

public class Solution25 {
    public ListNode reverse(ListNode head, ListNode tail){
        //这个翻转链表不是reverseAll，也不是reversePart，是从head reverse到tail
        ListNode temp1 = null;
        ListNode temp = head;
        ListNode temp2;
        while (temp != tail){
            temp2 = temp.next;
            temp.next = temp1;
            temp1 = temp;
            temp = temp2;
        }

        return temp1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //先反转第一组的，因为要保存好newHead
        //用循环定位到tail
        ListNode tail = head;
        for (int i = 0; i < k; i++){
            if(tail == null){
                //如果该组的长度不够k，就不用翻转了，直接返回该组的head
                return head;
            }
            tail = tail.next;
        }
        //此时定位到要反转的部分了，从head到tail（不包括tail）
        //用newHead保存新的头
        ListNode newHead = reverse(head, tail);
        //此时head还是原始链表的头部，也就是翻转后第一组的尾部，用它去连接第二组
        //第二组的头部是tail
        head.next = reverseKGroup(tail, k);

        return newHead;
    }
}
