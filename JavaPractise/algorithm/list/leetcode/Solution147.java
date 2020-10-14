package algorithm.list.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/27
 */

public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-9999);
        dummy.next = head;

        //双指针，这个地方是从head和head.next开始的
        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            //带上等于号保证稳定
            if (curr.val >= pre.val){
                pre = curr;
                curr = curr.next;
            }else {
                //这句话要注意，是temp=dummy，从哑结点开始找
                ListNode temp = dummy;
                //小于等于保证稳定
                while (temp.next != curr && temp.next.val <= curr.val){
                    temp = temp.next;
                }

                //先把curr从原来的位置删除，再想插入的事
                pre.next = curr.next;

                //把curr插到应该的位置
                curr.next = temp.next;
                temp.next = curr;

                //从pre的下一个再开始排序
                curr = pre.next;
            }
        }


        return dummy.next;
    }
}
