package algorithm.dp.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/19
 *
 * 状态转移 + 84
 */

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        //dp[i]表示以该行中第i列为右下角的最大矩形面积
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = (matrix[i][j] == '1') ? dp[j] + 1 : 0;
            }
            res = Math.max(res, largestRectangleArea(dp));
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int currH = (i == len) ? -1: heights[i];

            while (!stack.isEmpty() && currH <= heights[stack.peek()]) {

                //这个地方不要写错了
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i: i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }

            //不要忘了这句
            stack.push(i);
        }
        return res;
    }
}
