package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 *
 * 是按照行放Q的，第一行放第一个Q，然后看第二行，放第二个Q
 */

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        //生成N*N的棋盘
        char[][] arr = new char[n][n];
        //填充棋盘，每个格子默认是“.”表示没有放置皇后
        for(int i = 0; i < n; ++i) {
            Arrays.fill(arr[i],'.');
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(arr, 0, n, res);
        return res;
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

    private void dfs(char[][] arr, int x, int n, List<List<String>> res) {
        //x是从0开始计算的，当x==n时所有行的皇后都放置完毕，此时记录结果
        if(x == n) {
            List<String> ans = new ArrayList<String>();
            for(int i = 0 ; i < n; ++i) {
                StringBuilder tmp = new StringBuilder();
                for(int j = 0; j < n; ++j) {
                    if(arr[i][j] == '.') {
                        tmp.append(".");
                    } else {
                        tmp.append("Q");
                    }
                }
                ans.add(tmp.toString());
            }
            res.add(ans);
            return;
        }
        //遍历每一列
        for(int y = 0; y < n; ++y) {
            //检查[x,y]这一坐标是否可以放置皇后
            //如果满足条件，就放置皇后，并继续检查下一行
            if(check(arr, x, y, n)) {
                arr[x][y] = 'Q';
                dfs(arr, x + 1, n, res);
                arr[x][y] = '.';
            }
        }
    }


}
