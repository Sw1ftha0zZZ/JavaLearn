package algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/13
 */

public class Solution200 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                //bfs的起点
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;

                    Queue<Integer> queue = new LinkedList<>();
                    //将二维坐标转化为一维坐标
                    queue.offer(i * cols + j);
                    //同时设置为已经访问过
                    visited[i][j] = true;

                    //bfs
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        //得到坐标
                        int x = cur / cols;
                        int y = cur % cols;

                        //四个方向bfs
                        for (int[] direction : directions) {
                            int newX = x + direction[0];
                            int newY = y + direction[1];

                            //有讲究的，&&是短路运算，必须要inArea放前面，如果visited放前面会出现越界
                            if (inArea(newX, newY, rows, cols) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                                queue.offer(newX * cols + newY);
                                visited[newX][newY] = true;
                            }
                        }

                    }

                }
            }
        }

        return ans;
    }
}
