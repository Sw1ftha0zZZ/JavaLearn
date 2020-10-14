package algorithm.list.leetcode;


import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/09
 *
 * 双指针之快慢指针之找链表的中间结点
 *
 */

public class Solution234 {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightPart = reverseList(slow);

        ListNode leftTemp = head;
        ListNode rightTemp = rightPart;

        while (leftTemp != null && rightTemp != null) {
            if (leftTemp.val != rightTemp.val) {
                return false;
            }else {
                leftTemp = leftTemp.next;
                rightTemp = rightTemp.next;
            }
        }

        reverseList(rightPart);
        return true;
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(5);

        boolean flag = isPalindrome(head);


        System.out.println(flag);

    }



    public static boolean isPalindrome22(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        Stack<Integer> stack = new Stack<Integer> ();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null){
            if(stack.pop() != head.val){
                return false;
            }

            head = head.next;
        }

        return true;


    }

    public static boolean isPalindrome1(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        ListNode right = head.next;
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null){
            curr = curr.next.next;
            right = right.next;
        }
        Stack<ListNode> stack = new Stack<> ();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        //找到中间结点
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;//n2是右半区的第一个结点
        n1.next = null;
        ListNode n3 = null;
        //右半区反转
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;//n3->保存最后一个结点，以便后续恢复用
        n2 = head;//n2是左边第一个结点
        boolean res = true;
        //检查回文
        while (n1 != null && n2 != null){
            if(n1.val != n2.val){
                res = false;//这里不能直接return false，要把链表结构还原再return
                break;//跳出
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }




}
