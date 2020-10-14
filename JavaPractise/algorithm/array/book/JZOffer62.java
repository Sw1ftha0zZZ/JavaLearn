package algorithm.array.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class JZOffer62 {
    /**
     * 这个方法是从0到n - 1的数字
     * @param n 总人数
     * @param m 每数到第m个kill
     * @return 最后活下来的索引
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
