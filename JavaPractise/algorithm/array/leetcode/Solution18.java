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
 * FourSum
 */

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }

        //一定要先对数组排序
        Arrays.sort(nums);

        for (int first = 0; first < len - 3; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            //如果这个i和最小的三个的和都比target大，那这个i和后面的i就都不用看了，因为是从小到大排序的
            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }

            //如果这个i和最大的三个的和都比target小，那这个i就不要看了，看下一个i
            if (nums[first] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }


            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if (nums[first] + nums[second] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }

                int left = second + 1;
                int right = len - 1;

                while (left < right) {
                    if (nums[first] + nums[second] + nums[left] + nums[right] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);

                        //先跳过所有重复的
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //再做应该做的那次
                        left++;
                        //先跳过所有重复的
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //再做应该做的那次
                        right--;

                    }else if (nums[first] + nums[second] + nums[left] + nums[right] > target){
                        right--;
                    }else {
                        left++;
                    }
                }

            }

        }

        return res;
    }
}
