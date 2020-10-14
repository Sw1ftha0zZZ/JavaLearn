package algorithm.dfs;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 */

public class Solution79 {
    public boolean dfs(char[][] board, String word, int pos, int i, int j, int m, int n, int[][] visited){
        //终止条件
        if (pos == word.length()){
            return true;
        }

        //上下左右找
        if (i > 0 && visited[i - 1][j] == 0 && board[i - 1][j] == word.charAt(pos)){
            visited[i - 1][j] = 1;

            if (dfs(board, word, pos + 1, i - 1, j, m, n, visited)){
                return true;
            }

            visited[i - 1][j] = 0;
        }

        if (i < m - 1 && visited[i + 1][j] == 0 && board[i + 1][j] == word.charAt(pos)){
            visited[i + 1][j] = 1;

            if (dfs(board, word, pos + 1, i + 1, j, m, n, visited)){
                return true;
            }

            visited[i + 1][j] = 0;
        }

        if (j > 0 && visited[i][j - 1] == 0 && board[i][j - 1] == word.charAt(pos)){
            visited[i][j - 1] = 1;

            if (dfs(board, word, pos + 1, i, j - 1, m, n, visited)){
                return true;
            }

            visited[i][j - 1] = 0;
        }

        if (j < n - 1 && visited[i][j + 1] == 0 && board[i][j + 1] == word.charAt(pos)){
            visited[i][j + 1] = 1;

            if (dfs(board, word, pos + 1, i, j + 1, m, n, visited)){
                return true;
            }

            visited[i][j + 1] = 0;
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        //找到dfs搜索的起始点
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)){

                    //要查重，找到起始位置后建立visited数组
                    int[][] visited = new int[m][n];
                    //并且将起始位置的visited值设置为1
                    visited[i][j] = 1;

                    //进行dfs操作
                    if (dfs(board, word, 1, i, j, m, n, visited)){
                        return true;
                    }

                }
            }
        }

        return false;
    }
}
