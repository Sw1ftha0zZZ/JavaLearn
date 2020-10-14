package algorithm.list.book;

import algorithm.list.leetcode.ListNode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/24
 *
 * 单链表的选择排序，额外空间复杂度是o(1)，空间复杂度是o(n^2)
 *
 * 这个题没看懂，书的97页
 *
 */

public class SelectSort {
//    public ListNode selectionSort(ListNode head){
//
//    }

    public ListNode getSmallestPreNode(ListNode head){
        ListNode smallPre = null;
        ListNode small = head;

        ListNode pre = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val < small.val){
                smallPre = pre;
                small = temp;
            }
            pre = temp;
            temp = temp.next;
        }

        return smallPre;
    }
}
