package algorithm.string.leetcode;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/08
 */

public class Solution344 {
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = 0;
        if (len % 2 == 0) {
            left = len / 2 - 1;
            right = len / 2;
        }else {
            left = len / 2 - 1;
            right = len / 2 + 1;
        }

        while (left >= 0 && right <= len - 1) {
            swap(s, left, right);
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'a', 'n', 'n', 'a', 'h'};
        new Solution344().reverseString(s);

        for (char c: s) {
            System.out.println(c);
        }
    }
}
