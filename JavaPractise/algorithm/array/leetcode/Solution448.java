package algorithm.array.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 */

public class Solution448 {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (i + 1 != nums[i]) {

                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }

                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution448 s = new Solution448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = s.findDisappearedNumbers(nums);
        for (int num: ans) {
            System.out.println(num);
        }
    }
}
