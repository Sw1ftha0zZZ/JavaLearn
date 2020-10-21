package algorithm.dfs;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/17
 */

public class Solution52 {
    int ans = 0;
    public int totalNQueens(int n) {
        //生成N*N的棋盘
        char[][] arr = new char[n][n];
        //填充棋盘，每个格子默认是“.”表示没有放置皇后
        for(int i = 0;i < n; ++i) {
            Arrays.fill(arr[i],'.');
        }

        dfs(arr, 0, n);
        return ans;
    }
    //检查当前的行和列是否可以放置皇后
    private boolean check(char[][] arr, int x, int y, int n) {
        //检查竖着的一列是否有皇后
        for(int i = 0; i < x; ++i) {
            if(arr[i][y] == 'Q') {
                return false;
            }
        }
        //检查行
        for (int j = 0; j < y; j++){
            if (arr[x][j] == 'Q'){
                return false;
            }
        }

        //检查左上到右下的斜边是否有皇后
        //是按照行放的，所以只要检查之前的行就行，是从当前点往左上走
        //不用往右下走
        int i = x-1;
        int j = y-1;
        while(i >= 0 && j >= 0) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            --i;
            --j;
        }

        //检查左下到右上的斜边是否有皇后
        //是按照行放的，所以只要检查之前的行就行，是从当前点往右上走
        //不用往左下走
        i = x - 1;
        j = y + 1;
        while(i >= 0 && j < n) {
            if(arr[i][j] == 'Q') {
                return false;
            }
            --i;
            ++j;
        }
        return true;
    }
    private void dfs(char[][] arr, int x, int n) {
        //x是从0开始计算的，当x==n时所有行的皇后都放置完毕，此时记录结果
        if(x == n) {
            ans++;
            return;
        }
        //遍历每一列
        for(int y = 0; y < n; ++y) {
            //检查[x,y]这一坐标是否可以放置皇后
            //如果满足条件，就放置皇后，并继续检查下一行
            if(check(arr, x, y, n)) {
                arr[x][y] = 'Q';
                dfs(arr, x + 1, n);
                arr[x][y] = '.';
            }
        }
    }
}
