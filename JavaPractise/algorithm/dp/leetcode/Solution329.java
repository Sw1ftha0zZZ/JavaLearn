package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/18
 */

public class Solution329 {
    int n, m;

    //方向数组，表示上下左右
    //每次都有三种选择，不可能往回走
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public int dfs(int x, int y, int[][] matrix, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        //这句话不要忘了，已经访问过x, y
        //所以要加一
        ++dp[x][y];

        for (int[] dir: direction) {
            int a = x + dir[0];
            int b = y + dir[1];
            if (a >= 0 && a < n && b >= 0 && b < m && matrix[a][b] > matrix[x][y]) {

                //这个地方因为dp[a][b] 还不一定算过，所以要用dfs求
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(a, b, matrix, dp));
            }
        }

        return dp[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        n = matrix.length;
        m = matrix[0].length;

        //dp[i][j]表示走到(i, j)这个点之前走过的最长路径是多少
        int[][] dp = new int[n][m];

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, dp));
            }
        }

        return ans;
    }

}
