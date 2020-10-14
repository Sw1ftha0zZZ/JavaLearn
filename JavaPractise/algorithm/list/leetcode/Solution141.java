package algorithm.list.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/08
 */

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode temp1 = head;
        Set<ListNode> set = new HashSet<>();
        while (temp1 != null){
            if(set.contains(temp1)){
                return true;
            }else {
                set.add(temp1);
            }

            temp1 = temp1.next;
        }

        return false;

    }

    //双指针之快慢指针，两个指针的移动速度不一样
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
