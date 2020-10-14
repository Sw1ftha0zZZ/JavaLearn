package algorithm.dp.leetcode;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/23
 */

public class Solution279 {
    public int numSquares(int n) {
        int maxCoinCount = (int)Math.sqrt(n);

        int[] coins = new int[maxCoinCount];

        for (int i = 0; i < maxCoinCount; i++) {
            coins[i] = (i + 1) * (i + 1);
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[n];
    }
}
