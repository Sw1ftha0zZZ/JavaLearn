package algorithm.stackAndQueue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/22
 *
 * 单调栈
 *
 */

public class Solution84 {
    //[2,1,5,6,2,3]
    public int largestRectangleArea(int[] heights) {
        //特例
        if (heights == null || heights.length == 0){
            return 0;
        }

        //由于要找到这个高度对应的索引，所以栈中存放的元素是索引而不是高度
        Deque<Integer> stack = new ArrayDeque<>();
        //要返回的结果
        int res = 0;

        //要弹出数组中最后一个元素，所以这里i <= heights.length
        for (int i = 0; i <= heights.length; i++){

            //当前的高度，如果i == heights.length的话，高度设为-1，保证栈中所有元素都能弹出来
            int curr = (i < heights.length) ? heights[i] : -1;

            //2 < 6，h = 6. w = 2的索引 - 5的索引 - 1；
            //保证栈严格单调
            while (!stack.isEmpty() && curr <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }

            stack.push(i);
        }
        return res;
    }
}
