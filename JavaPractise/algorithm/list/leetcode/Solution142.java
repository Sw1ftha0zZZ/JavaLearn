package algorithm.list.leetcode;
import	java.util.HashSet;

import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/08
 */

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {

            if (visited.contains(temp)) {
                return temp;
            }

            visited.add(temp);
            temp = temp.next;

        }

        return null;
    }


    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {return null;}
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {break;}
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
