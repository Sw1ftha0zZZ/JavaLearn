package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/14
 */

public class Solution103 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        //先找dfs的起点
        //dfs的起点为第一行，最后一行，第一列，最后一列的O处

        //第一列
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }
        //最后一列
        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, board);
            }
        }
        //第一行
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }
        //最后一行
        for (int i = 0; i < cols; i++) {
            if (board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, board);
            }
        }

        //遍历一遍board，将O换成X，将A换成O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    //当前的x，y是'o'，把x，y处的'o'换成'a'，再看x,y周围是否有连通的'o'，对连通的继续做dfs
    public void dfs (int x, int y, char[][] board) {
        board[x][y] = 'A';

        for (int[] direction: directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (inArea(newX, newY, board.length, board[0].length) && board[newX][newY] == 'O') {
                dfs(newX, newY, board);
            }
        }
    }
}
