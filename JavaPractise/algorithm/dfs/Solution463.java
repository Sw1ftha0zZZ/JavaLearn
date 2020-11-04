package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/30
 */

public class Solution463 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans += dfs(i, j, grid, visited);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, boolean[][] visited) {


        //走到了网格外，周长+1
        if (!inArea(x, y, grid.length, grid[0].length)) {
            return 1;
        }
        //走到了水域上，周长+1
        if (grid[x][y] == 0) {
            return 1;
        }

        //走到了之前走过的陆地
        if (grid[x][y] == 1 && visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;

        int ans = 0;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            ans += dfs(newX, newY, grid, visited);
        }
        return ans;
    }
}
