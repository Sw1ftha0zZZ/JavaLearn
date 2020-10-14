package algorithm.array.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/05
 *
 * 3Sum
 */

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        //一定要先对数组排序
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            int first = i;
            int target = -nums[first];
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;

            for (int second = first + 1; second < len - 1; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (third == second) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
