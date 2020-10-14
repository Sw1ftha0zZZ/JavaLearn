package algorithm.list.leetcode;

import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/20
 *
 * 放到栈里或者用逆序函数处理list
 * 然后用头插法依次插入
 *
 */

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer> ();
        Stack<Integer> stack2 = new Stack<Integer> ();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode temp = null;

        while ((!stack1.isEmpty()) || (!stack2.isEmpty())){
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            ans.next = new ListNode((n1 + n2 + carry) % 10);
            ans.next.next = temp;
            carry = (n1 + n2 + carry) / 10;
            temp = ans.next;
        }
        if (carry == 1){
            ans.next = new ListNode(carry);
            ans.next.next = temp;
        }

        return ans.next;

    }

    public ListNode reverseList(ListNode head) {
        ListNode temp1 = null;
        ListNode temp = head;
        ListNode temp2;
        while (temp != null){
            temp2 = temp.next;
            temp.next = temp1;
            temp1 = temp;
            temp = temp2;
        }
        return temp1;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode temp1 = reverseList(l1);
        ListNode temp2 = reverseList(l2);

        ListNode dummy = new ListNode(-1);
        ListNode temp = null;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int n1 = temp1 != null ? temp1.val : 0;
            int n2 = temp2 != null ? temp2.val : 0;
            dummy.next = new ListNode((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
            dummy.next.next = temp;
            temp = dummy.next;
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
        }

        if (carry == 1){
            dummy.next = new ListNode(carry);
            dummy.next.next = temp;
        }
        l1 = reverseList(temp1);
        l2 = reverseList(temp2);

        return dummy.next;
    }

}
