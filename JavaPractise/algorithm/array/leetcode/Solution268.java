package algorithm.array.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 */

public class Solution268 {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
