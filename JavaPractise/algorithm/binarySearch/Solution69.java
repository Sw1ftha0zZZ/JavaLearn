package algorithm.binarySearch;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/21
 */

public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = (left + right + 1) >> 1;

            if ((long)mid * mid > x) {
                right = mid - 1;
            }else {
                left = mid;
            }

        }
        return left;
    }
}
