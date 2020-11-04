package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/30
 */

public class Solution329 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int dfs(int x, int y, int[][] matrix, int[][] dp) {
        //之前已经算过了，这里dp也就充当了visited的角色
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        //访问了当前结点，所以dp++
        dp[x][y]++;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (inArea(newX, newY, matrix.length, matrix[0].length) && matrix[newX][newY] > matrix[x][y]) {
                //这个地方+1一定不要忘了
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(newX, newY, matrix, dp));
            }
        }

        return dp[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        //dp[i][j]表示到位置i，j处的最长递增路径长度
        int[][] dp = new int[rows][cols];

        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(i, j, matrix, dp));
            }
        }

        return res;
    }
}
