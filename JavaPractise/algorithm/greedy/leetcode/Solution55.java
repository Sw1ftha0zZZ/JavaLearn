package algorithm.greedy.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/24
 */

public class Solution55 {
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int maxEnd = 0;

        for (int i = 0; i < len; i++) {
            if (i <= maxEnd) {
                maxEnd = Math.max(maxEnd, i + nums[i]);
                if (maxEnd >= len - 1) {
                    return true;
                }
            }

        }
        return false;
    }
}
