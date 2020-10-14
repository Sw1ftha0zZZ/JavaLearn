package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/29
 */

public class Solution1312 {
    public int minInsertions(String s) {
        int len = s.length();

        //dp[i][j]表示对于字符串s位置从i到j的子串，让该子串变成回文串的最小插入次数
        //i==j时，dp[i][j] = 0;
        int[][] dp = new int[len][len];

        //i要从大到小
        for (int i = len - 2; i >= 0; i--) {

            //j从小到大
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j - 1];

                }else {

                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;

                }
            }
        }

        return dp[0][len - 1];
    }
}
