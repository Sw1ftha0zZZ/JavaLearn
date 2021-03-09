package algorithm.array.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/11/4
 */

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> ans = new ArrayList<>();

        boolean flag = false;
        //逐个区间比较
        for (int[] interval : intervals) {

            //遍历到的小区间在被插入的区间的右侧，而且没有交集
            if (interval[0] > right) {

                //没插入过才插入
                if (!flag) {
                    ans.add(new int[] {left, right});
                    flag = true;
                }

                ans.add(interval);
            }else if (interval[1] < left) {
                //遍历到的小区间在被插入区间的左侧，而且没有交集
                ans.add(interval);
            }else {
                //有交集，求并集
                //这个left-right会在遇到小区间的左端点比right大的时候插入，或者被插入到最后
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!flag) {
            ans.add(new int[] {left, right});
        }

        int[][] ansArr = new int[ans.size()][2];
        int index = 0;
        for (int[] a: ans) {
            ansArr[index] = a;
            index++;
        }
        return ansArr;
    }

}
