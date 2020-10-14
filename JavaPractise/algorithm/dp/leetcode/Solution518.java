package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/22
 */

public class Solution518 {
    //套完全背包的公式
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        //什么也不选也是一种选择
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    //状态转移分析
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        //dp[i][j]表示只选前i个硬币，总金额为j的组合数
        int[][] dp = new int[len + 1][amount + 1];

        //总金额为0的情况赋初始值为1，没有也是一种选择
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j - coins[i -1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i -1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }


            }
        }

        return dp[len][amount];
    }
}
