package algorithm.dfs.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/3
 */

public class JZOffer12 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
    public boolean dfs(char[][] board, int x, int y, String word, int len, boolean[][] visited) {
        if (len == word.length()) {
            return true;
        }


        for (int[] direction: directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            //这里是len
            if (inArea(newX, newY, board.length, board[0].length) && board[newX][newY] == word.charAt(len) && !visited[newX][newY]) {

                visited[newX][newY] = true;

                //这里要len+1
                if (dfs(board, newX, newY, word, len + 1, visited)) {
                    return true;
                }

                visited[newX][newY] = false;
            }

        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (word.charAt(0) == board[i][j]) {
                    //是在这初始化visited的
                    boolean[][] visited = new boolean[rows][cols];
                    visited[i][j] = true;
                    //从第二个开始找，所以传入的是1
                    if (dfs(board, i, j, word, 1, visited)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }
}
