package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/19
 */

public class Solution576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        /**
         动态规划, dp[i][j][k]表示从(i, j)开始在k步内移除边界的路径数.
         可知dp[i][j][k]只与(i, j)四周邻接点在k-1步内移除边界的路径数有关.
         dp[i][j][k] = dp[i-1][j][k-1] + dp[i+1][j][k-1] + dp[i][j-1][k-1] + dp[i][j+1][k-1];
         空间优化: 可以看出重复利用一个二维数组储存路径数即可(k-1步更新之后就无需保存)
         **/

        /* 无空间优化版
        if(N <= 0) return 0;
        int mod = 1000000007;
        int[][][] dp = new int[m][n][N+1];

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int k = 1; k <= N; ++k) {
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        // 边界处理, 无论在第几步只要位置处于边界都包含一步出界的情况
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                            dp[x][y][k] += 1;
                        else
                            dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k-1]) % mod;
                    }
                }
            }
        }

        return dp[i][j][N];
        */

        // 带有空间优化
        if(N <= 0) {return 0;}
        int mod = 1000000007;
        int ret = 0;
        int[][] dp = new int[m][n]; // 保存第k步的结果
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int k = 1; k <= N; ++k) {
            int[][] temp = new int[m][n]; // 保存第k-1步的结果
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                            temp[x][y] += 1;
                        else
                            temp[x][y] = (dp[nx][ny] + temp[x][y]) % mod;
                    }
                }
            }
            dp = temp;
        }

        return dp[i][j];
    }
}
