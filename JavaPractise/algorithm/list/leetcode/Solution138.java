package algorithm.list.leetcode;

import	java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/06/20
 */

public class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node> ();
        Node temp = head;
        while (temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }


    public Node copyRandomList1(Node head){
        if (head == null){
            return null;
        }

        Node temp = head;
        //在后面新建
        while (temp != null) {
            Node tempNext = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = tempNext;
            temp = temp.next.next;
        }
        temp = head;
        //复制rand指针
        while (temp != null) {
            Node curr = temp.next;
            curr.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node newTemp = dummy;
        temp = head;
        //拆分
        while (temp != null){
            newTemp.next = temp.next;
            newTemp = newTemp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        newTemp.next = null;

        return dummy.next;
    }


}
