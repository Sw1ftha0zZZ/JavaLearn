package algorithm.list.book;

import algorithm.list.leetcode.ListNode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/03
 */

public class Josephus {

    /**
     *
     * @param head 链表头节点
     * @param m 每数到第m个kill
     * @return 最后生还的节点
     */
    public ListNode josephusKillEasy(ListNode head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }

        //统计链表的长度
        ListNode prev = head.next;
        int count = 1;
        while (prev != head) {
            count++;
            prev = prev.next;
        }
        int res = lastRemaining(count, m);

        //这个题是从1开始，不是从0开始，所以要加一
        res++;

        //直到还剩一个的时候，就不用再往下找了
        while (res > 1) {
            head = head.next;
            res--;
        }

        //最后活下来的自己组成环
        head.next = head;
        return head;
    }

    /**
     * 这个方法是从0到n - 1的数字
     * @param n 总人数
     * @param m 每数到第m个kill
     * @return 最后活下来的索引
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    /**
     * 暴力解法，时间复杂度O（N*M）
     *
     * @param head
     * @param m
     * @return
     */
    public ListNode josephusKill(ListNode head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        //在环形链表中找到head的前驱
        ListNode prev = head;
        while (prev.next != head) {
            prev = prev.next;
        }

        int count = 0;

        while (head != prev) {
            if (++count == m) {
                prev.next = head.next;
                count = 0;
            }else {
                prev = prev.next;
            }

            head = prev.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;

//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        //ListNode res = new Josephus().josephusKillEasy(head, 3);
        Josephus solution = new Josephus();
        //System.out.println(solution.josephusKill(head, 3).val);

        System.out.println(solution.josephusKillEasy(head, 3).val);

    }


}
