package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/21
 */

public class Solution160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempB;
    }
}
