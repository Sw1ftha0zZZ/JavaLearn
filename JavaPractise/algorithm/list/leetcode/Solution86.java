package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/04
 *
 * 不用修改原始链表
 * 新建两个链表before和after
 * 在遍历原始链表的过程中，小于x的插入到before中，大于x的插入到after中
 *
 */

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null){
            if(head.val < x){
                before.next = new ListNode(head.val);
                before = before.next;
            }else {
                after.next = new ListNode(head.val);
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;

        before.next = afterHead.next;

        return beforeHead.next;

    }
}
