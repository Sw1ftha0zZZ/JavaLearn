package algorithm.string.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int nLen = name.length();
        int tLen = typed.length();

        int i = 0;
        int j = 0;

        while (j < tLen) {
            if (i < nLen && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }else {
                return false;
            }
        }
        return i == nLen;
    }
}
