package algorithm.stackAndQueue.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/04/30
 */

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < nums2.length; i++){
            while(!stack.empty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.empty()){
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
