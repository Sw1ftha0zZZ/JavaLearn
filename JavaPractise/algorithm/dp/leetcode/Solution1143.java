package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/08
 *
 * LCS
 * 这个题也是两个字符串的DP问题
 * 和LC 72是一样的套路
 * 对于两个字符串的DP问题，在前面补上空位，建立好DP table，分析状态转移
 *
 * 可以根据返回值来决定i，j的遍历顺序。是从大到小还是从小到大
 */

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        //在两个字符串前都加上一个空位
        int[][] dp = new int[m + 1][n + 1];

        //要返回的是dp[m][n]，所以对i和j都是从小到大遍历
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    //这里是两个选最大，没有算上dp[i - 1][j - 1]，因为根据题意，dp[i - 1][j - 1]一定是这三个里面最小的，没必要带上它比较
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
