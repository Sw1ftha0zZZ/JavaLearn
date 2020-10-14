package algorithm.dp.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/13
 */

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //对于第一列来说，一直初始化到遇到障碍物为止
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        //对于第一行来说，一直初始化到遇到障碍物为止
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                //dp数组元素初始化为0了，对于有障碍物的位置（if (obstacleGrid[i][j] == 1)）dp[i][j] = 0;
                //对于没有障碍物的位置用状态转移
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        //相当于对第一列已经做初始化了，在后面判断是否有障碍物的时候，会把有障碍的地方置为0
        //对于第一列的初始化包含在for中
        dp[0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                //下面的判断条件里面其实可以不用加&& obstacleGrid[i][j] == 0，加上可读性更强一些
                if (j - 1 >= 0 && obstacleGrid[i][j] == 0){
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

}
