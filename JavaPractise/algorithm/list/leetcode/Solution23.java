package algorithm.list.leetcode;

import java.util.PriorityQueue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/12
 */

public class Solution23 {

    /**
     * 方法一：使用堆实现
     *
     * 时间复杂度O(n*log(k))，n 是所有链表中元素的总和，k 是链表个数
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!queue.isEmpty()) {
            ListNode p = queue.poll();

            temp.next = p;
            temp = temp.next;

            if (p.next != null) {
                queue.offer(p.next);
            }
        }
        return dummy.next;
    }


    /**
     * 方法二：分治法 + LC 21
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;

        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
