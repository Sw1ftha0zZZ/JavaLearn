package algorithm.array.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/05
 * lru
 */

public class Solution146 {

    class LRUCache {
        class MyNode {
            int key;
            int value;
            MyNode prev;
            MyNode next;

            public MyNode(int k, int v) {
                key = k;
                value = v;
            }
        }

        private MyNode dummy;
        private MyNode tail;
        private int length;
        private int capacity;
        private Map<Integer, MyNode> map;

        public LRUCache(int cap) {

            dummy = new MyNode(0, 0);
            //没有设置一个空的尾指针，直接让最后一个元素就是尾指针
            tail = dummy;
            length = 0;
            capacity = cap;
            map = new HashMap<>();

        }

        //只包含对链表的操作，map的remove放到具体的get和put中去
        private void removeFirst() {

            dummy.next = dummy.next.next;
            //如果dummy后面还有tail的话。不能写成dummy.next != tail，这句话是除了dummy还有一个元素的意思
            //dummy.next != null代表着只有dummy了
            if (dummy.next != null) {
                dummy.next.prev = dummy;
            }
        }

        //只包含对链表的操作，map的put放到具体的get和put中去
        private void addLast(MyNode node) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }


        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            //找到了这个值，要把这个值放到链表的尾部
            MyNode node = map.get(key);
            //从原来的位置删除
            //如果之前就在最后，那就不用addLast了
            if (node != tail) {
                node.prev.next = node.next;
                node.next.prev = node.prev;

                node.next = null;
                node.prev = null;
                //放到最后，本来map中就有这个kv，不需要再对map操作，只需要对链表操作
                addLast(node);
            }
            return node.value;
        }

        public void put(int key, int value) {
            MyNode curr = new MyNode(key, value);
            if (map.containsKey(key)) {
                //如果有，就把原来的那个先删除掉
                MyNode node = map.get(key);
                if (node != tail) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                    node.next = null;
                    node.prev = null;
                }else {
                    //找到了，而且就在最后，那把原来的kv删掉，tail往前指，后面再加上新的kv
                    tail = tail.prev;
                }
            }else {
                //没找到，那就要比较长度和容量
                if (length < capacity) {
                    length++;
                }else {
                    //对map和链表都做操作，这个remove不要写错了
                    map.remove(dummy.next.key);
                    removeFirst();
                }
            }
            //不管是上面的哪种情况，都是要把kv放到map里面而且链表最后一个是结点n的
            map.put(key, curr);
            addLast(curr);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 使用LinkedHashMap实现的版本（最好不要用）
     */
    class LRUCache1 {

        private LinkedHashMap<Integer, Integer> cache;

        private int cap;

        public LRUCache1(int capacity) {
            cache = new LinkedHashMap<>();
            cap = capacity;
        }

        private void makeRecent(int key) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            makeRecent(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                makeRecent(key);
                return;
            }
            if (cache.size() >= cap) {
                int old = cache.keySet().iterator().next();
                cache.remove(old);
            }
            cache.put(key, value);
        }

    }

}
