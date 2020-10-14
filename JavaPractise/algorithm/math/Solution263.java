package algorithm.math;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/20
 *
 * 丑数
 *
 * 于是我们按照2,3,5 的顺序依次循环除，当除到不是当前因数的倍数时，进行下一个因素的整数，这样，最后剩下的数为1则为丑数
 */

public class Solution263 {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor: factors) {

            //这里是while不是if
            while (num % factor == 0) {
                num /= factor;
            }
        }

        return num == 1;
    }

}
