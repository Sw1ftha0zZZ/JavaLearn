package algorithm.dp.leetcode;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 * 为啥 dp 数组初始化为 amount + 1 呢
 * 因为凑成 amount 金额的数最多只可能等于 amount（全用 1 元面值的）
 * 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
 *
 */

public class Solution322 {

    //套完全背包的公式
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin: coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public int coinChange1(int[] coins, int amount) {

        //dp[i]表示amount为i需要至少需要多少枚硬币
        int[] dp = new int[amount + 1];

        //要将dp数组初始化为amoount + 1
        //最多需要amount枚1元的硬币，amount + 1相当于无穷大，便于后面取最小值
        Arrays.fill(dp, amount + 1);

        //base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){

            //减去各个面额的硬币
            //要保证还能减
            for (int coin: coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }

        }


        return dp[amount] == amount + 1 ? -1: dp[amount];
    }



}
