package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/18
 */

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int[] dp = new int[len];

        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {


                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
