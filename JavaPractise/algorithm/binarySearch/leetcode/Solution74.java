package algorithm.binarySearch.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/26
 */

public class Solution74 {

    /**
     * 直接把二维数组当作一维数组去做二分，当然需要对下标做一些处理
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int midIndex = (left + right) >> 1;

            int mid = matrix[midIndex / n][midIndex % n];

            if (mid == target) {
                return true;
            }else if (mid < target) {
                left = midIndex + 1;
            }else {
                right = midIndex - 1;
            }
        }
        return false;
    }



    /**
     * 先定位在哪行再二分
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (target == matrix[i][0] || target == matrix[i][matrix[0].length - 1]) {
                return true;
            }

            if ((target > matrix[i][0]) && (target < matrix[i][matrix[0].length - 1])) {
                rows = i;
            }
        }

        if (rows == Integer.MAX_VALUE) {
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (target == matrix[rows][mid]) {
                return true;
            }else if (target > matrix[rows][mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }
}
