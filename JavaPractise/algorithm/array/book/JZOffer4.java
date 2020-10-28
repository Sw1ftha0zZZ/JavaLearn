package algorithm.array.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/26
 */

public class JZOffer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        //从左下角开始搜索，从左下角开始
        //严格往上的都是比他小的，严格往右的都是比他大的
        int x = matrix.length - 1;
        int y = 0;

        while (x >= 0 && y <= matrix[0].length - 1) {
            if (matrix[x][y] == target) {
                return true;
            }else if (matrix[x][y] > target) {
                x--;
            }else {
                y++;
            }
        }
        return false;
    }
}
