package algorithm.dp.leetcode;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/13
 */

public class Solution62 {
    /**
     * 使用二维数组
     * dp[i][j]表示走到位置i, j时的最大路径数
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //对于第一行和第一列来说，从0,0走到这两条线上任何一点的最大路径数都是1
        for (int i = 0; i < n; ++i){
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; ++i){
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 只需要保留最后一行的信息，中间的会被覆盖
     * 使用一维数组（滚动数组），但是肯定是要用两层循环的
     * dp[i]表示走到该行的位置i时的最大路径数
     * dp[i] = dp[i](上一行的位置i处的还没更新的) + dp[i - 1]（已经更新的，这一行的，位置i - 1的）
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++){
            //这里j不需要倒序，是因为这里dp[i - 1]不是从上一层转移来的，是从这层转移来的
            //lc 120需要倒序是因为dp[i - 1]是要保证是上一层的，而不是这层的，所以必须j是倒序遍历
            for (int j = 1; j < n; j++){
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
