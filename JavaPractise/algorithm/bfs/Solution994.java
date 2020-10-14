package algorithm.bfs;
import	java.util.LinkedList;
import	java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/27
 */

public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        //队列中存放的是坐标
        Queue<int[]> queue = new LinkedList<> ();

        //新鲜的橘子数
        int count = 0;

        //将烂橘子的坐标放到队列中
        for (int i = 0; i < M; ++i){
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1){
                    count++;
                }else if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //腐烂的轮数
        int round = 0;

        //bfs
        while (count > 0 && !queue.isEmpty()){
            round++;
            int n = queue.size();

            for (int i = 0; i < n; ++i) {
                int[] bad = queue.poll();
                int r = bad[0];
                int c = bad[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }

            }

        }

        if (count > 0){
            return -1;
        }else {
            return round;
        }

    }
}
