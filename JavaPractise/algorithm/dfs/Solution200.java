package algorithm.dfs;

import java.util.LinkedList;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/13
 *
 * 方向数组
 */

public class Solution200 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public void dfs (int x, int y, boolean[][] visited, char[][] grid) {
        visited[x][y] = true;

        for (int[] direction : directions) {
            int newRow = x + direction[0];
            int newCol = y + direction[1];

            //注意：条件有三条：不越界 + 没访问过 + 是1
            if (inArea(newRow, newCol, visited.length, visited[0].length) && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(newRow, newCol, visited, grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return ans;
    }


}
