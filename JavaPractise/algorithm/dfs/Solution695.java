package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/30
 */

public class Solution695 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int dfs(int x, int y, int[][] grid, boolean[][] visited) {
        //出界了或者遇到水域了，返回0
        if (!inArea(x, y, grid.length, grid[0].length) || grid[x][y] == 0) {
            return 0;
        }
        //如果之前的访问过，那也返回0
        if (grid[x][y] == 1 && visited[x][y]) {
            return 0;
        }

        //当前这个dfs函数的值，这样可以保证递归回来之后的值还是对的
        //如果你把temp声明在外面，而且dfs返回值是void的话，会出现dfs递归回来的值是上一层的值，不是最终值
        //dfs声明为int，而且temp声明在当前dfs函数内，这样可以保证递归回来之后的值还是对的
        int temp = 1;
        visited[x][y] = true;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            temp += dfs(newX, newY, grid, visited);
        }
        return temp;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j, grid, visited));
                }
            }
        }
        return ans;
    }
}
