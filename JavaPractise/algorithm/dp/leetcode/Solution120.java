package algorithm.dp.leetcode;

import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/11
 */

public class Solution120 {


    /**
     * 这个方法中dp[i][j]表示从根节点到位置i，j时的路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < len; ++i) {
            //头和尾只有一种情况
            //这个是头
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            //到对角线之前的情况
            for (int j = 1; j < i; j++) {
                //对于坐标为(i, j)的点，有两种往上的情况
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);

            }

            //这个是尾
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int result = dp[len - 1][0];
        for (int num: dp[len - 1]){
            result = Math.min(result, num);
        }
        return result;
    }


    /**
     * 这个方法中dp[i]表示在该层时从根节点到位置i时的路径和
     * 最后只保留最后一层的路径和，中间层的路径和会被覆盖掉
     * 所以对于对角线处和第一个点处的求和是很好计算的
     * 难点在于对中间点的计算
     * 关键在于从大到小遍历，这样才能保证用于状态更新的dp[j] 和 dp[j - 1]都是上一层的，是没有被更新过的
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < len; ++i) {
            //这句话不要写错，是从i-1加过来的
            dp[i] = dp[i - 1] + triangle.get(i).get(i);

            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }

        int result = dp[0];
        for (int num: dp){
            result = Math.min(result, num);
        }
        return result;
    }

}
