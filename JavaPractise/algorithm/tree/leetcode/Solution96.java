package algorithm.tree.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/16
 * 动态规划
 *
 */

public class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
