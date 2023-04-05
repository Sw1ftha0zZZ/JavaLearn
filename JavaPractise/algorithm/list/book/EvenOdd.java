package algorithm.list.book;

import algorithm.list.leetcode.ListNode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */


public class EvenOdd {

    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode before = null;
        ListNode temp = node;
        ListNode after = node;
        while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        return before;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    private ListNode sortList(ListNode input) {
        if (input == null || input.next == null || input.next.next == null) {
            return input;
        }
        int index = 1;
        ListNode oddList = new ListNode(-1);
        ListNode oddTemp = oddList;
        ListNode evenList = new ListNode(-1);
        ListNode evenTemp = evenList;
        while (input != null) {
            if (index % 2 == 0) {
                evenTemp.next = new ListNode(input.val);
                evenTemp = evenTemp.next;
            } else {
                oddTemp.next = new ListNode(input.val);
                oddTemp = oddTemp.next;
            }
            index++;
            input = input.next;
        }

        ListNode asecEvenList = reverseList(evenList.next);
        ListNode asecOddList = oddList.next;
        ListNode result = mergeList(asecEvenList, asecOddList);
        return result;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(200);
        input.next.next = new ListNode(10);
        input.next.next.next = new ListNode(120);
        input.next.next.next.next = new ListNode(30);
        input.next.next.next.next.next = new ListNode(8);
        input.next.next.next.next.next.next = new ListNode(88);
        input.next.next.next.next.next.next.next = new ListNode(4);


        ListNode result = new EvenOdd().sortList(input);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        System.out.println("Hello World!");
    }
}