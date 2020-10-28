package algorithm.hash.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/27
 */

public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Map.Entry<Integer, Integer> ans = null;

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (ans == null || entry.getValue() > ans.getValue()) {
                ans = entry;
            }
        }
        return ans.getKey();
    }
}
