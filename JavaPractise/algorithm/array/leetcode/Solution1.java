package algorithm.array.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/03
 */

public class Solution1 {

    /**
     * 可读性更高
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
        }
        return new int[] {-1, -1};
    }


    /**
     * 一趟for循环，但是可读性不太高
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
