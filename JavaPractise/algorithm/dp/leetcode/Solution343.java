package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/23
 */

public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            //至少要拆分成两个，所以这里不是j <= i
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }

        return dp[n];
    }
}
