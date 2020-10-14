package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/27
 */

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        int res = dp[0];
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }

    //优化空间复杂度
    public int maxSubArray1(int[] nums) {

        int ans = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }

            ans = Math.max(ans, sum);
        }

        return ans;

    }
}
