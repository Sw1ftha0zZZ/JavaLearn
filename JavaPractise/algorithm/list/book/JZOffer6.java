package algorithm.list.book;

import algorithm.list.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/26
 */

public class JZOffer6 {

    /**
     * 递归法
     * 递归的本质也是在使用栈，只不过是程序调用栈，因为没有显式在代码中体现出来，所以常常被忽略了
     */
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
    void recur(ListNode head) {
        if(head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }




    /**
     * 辅助栈法
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }
}
