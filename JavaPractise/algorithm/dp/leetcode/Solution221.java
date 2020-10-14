package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/18
 */

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //dp[i][j]表示以(i, j)为右下角最大的正方形边长是多少
        int[][] dp = new int[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else {


                    //至少能保证以它自己为边长的正方形，这个地方不要忘了
                    dp[i][j] = 1;


                    if (i >= 1 && j >= 1) {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                    if (dp[i][j] > res) {
                        res = dp[i][j];
                    }

                }
            }
        }

        return res * res;
    }

}
