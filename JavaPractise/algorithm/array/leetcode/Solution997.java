package algorithm.array.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/16
 */

public class Solution997 {
    //双指针法
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ans = new int[len];

        //注意这种for循环的写法，第一个位置是声明变量的，**声明变量只要第一个给类型就行了**，而且是**用逗号分隔**的
        //第二个是循环退出条件
        //第三个可以先空着，然后在循环内部具体做++/--
        for (int i = 0, j = len - 1, pos = len - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                i++;
            }else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }

        return ans;
    }
}
