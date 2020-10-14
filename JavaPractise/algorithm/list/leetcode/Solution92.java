package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/07
 *
 * 反转链表的指定部分
 *
 * 递归 10.4 + 迭代 10.4
 */

public class Solution92 {

    /**
     ** 递归解法
     */
    // 后驱节点
    ListNode successor = null;

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode newHead = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return newHead;
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }



    /**
     ** 迭代解法
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;

        //找到反转起点的前一个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        //start节点是真正开始要反转的节点
        ListNode start = pre.next;
        ListNode before = null;
        ListNode after = null;

        //反转第m个到第n个
        for (int i = m; i <= n; i++) {
            after = start.next;
            start.next = before;
            before = start;
            start = after;
        }

        //pre.next还能定位回反转的起点，将反转起点的next指针指向after
        pre.next.next = after;
        //将反转起点的前一个节点的next指针指向反转结果的开始处
        pre.next = before;

        return dummy.next;
    }
}
