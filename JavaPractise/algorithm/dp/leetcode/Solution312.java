package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/08
 * 戳气球
 */

public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        //改变问题：在一排气球points中，请你戳破气球0和气球n+1之间的所有气球（不包括0和n+1）
        //使得最终只剩下气球0和气球n+1两个气球，最多能够得到多少分？
        int[] points = new int[n + 2];
        //假设 nums[-1] = nums[n] = 1, 但注意它们不是真实存在的所以并不能被戳破
        points[0] = 1;
        points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        //dp[i][j] = x表示，戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数为x。
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {

                //k代表最后一个被戳破的气球
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }

            }
        }
        return dp[0][n + 1];
    }
}
