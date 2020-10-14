package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/05/31
 */

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(-1);
        ListNode tempResult = result;
        while(l1 != null&&l2 != null){
            if(l1.val <= l2.val){
                tempResult.next = new ListNode(l1.val);
                l1 = l1.next;
                tempResult = tempResult.next;
            }else {
                tempResult.next = new ListNode(l2.val);
                l2 = l2.next;
                tempResult = tempResult.next;
            }
        }

        tempResult.next = l1==null ? l2 : l1;

        return result.next;
    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if(l1 == null&&l2 == null){
            return null;
        }
        if(l1 == null&&l2 != null){
            return l2;
        }
        if(l1 != null&&l2 == null){
            return l1;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode result;

        //the first node
        if(temp1.val <= temp2.val){
            result = new ListNode(temp1.val);
            temp1 = temp1.next;
        }else {
            result = new ListNode(temp2.val);
            temp2 = temp2.next;
        }

        ListNode tempResult = result;

        while (temp2 != null&&temp1 != null){
            if(temp1.val <= temp2.val){
                tempResult.next = new ListNode(temp1.val);
                temp1 = temp1.next;
                tempResult = tempResult.next;
            }else {
                tempResult.next = new ListNode(temp2.val);
                temp2 = temp2.next;
                tempResult = tempResult.next;
            }
        }
        while (temp1 != null) {
            tempResult.next = new ListNode(temp1.val);
            temp1 = temp1.next;
            tempResult = tempResult.next;
        }
        while (temp2 != null) {
            tempResult.next = new ListNode(temp2.val);
            temp2 = temp2.next;
            tempResult = tempResult.next;
        }
        return result;
    }
}
