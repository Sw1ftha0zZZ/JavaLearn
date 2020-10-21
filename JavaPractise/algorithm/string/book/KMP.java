package algorithm.string.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/16
 */

public class KMP {

    /**
     *
     * @param master 主串
     * @param pattern 模式串
     * @return
     */
    public int KMPMatch(char[] master, char[] pattern) {
        int masterLen = master.length;
        int patternLen = pattern.length;

        //得到模式串的next数组
        int[] next = getNext(pattern);

        //开始匹配，i指针是指向主串的指针，这个指针只会往前走或者不走，不会往回走
        //j指针是指向模式串的指针，这个指针会往前走
        int j = 0;
        for (int i = 0; i < masterLen; i++) {

            //走到最长公共前后缀子串的位置
            while (j > 0 && pattern[j] != master[i]) {
                j = next[j - 1] + 1;
            }

            //如果这样，i，j都往后走
            if (pattern[j] == master[i]) {
                j++;
            }

            //如果j已经走到模式串的末尾，那就代表已经找到了，要返回的就是模式串的起始位置在主串中出现的坐标
            if (j == patternLen) {
                return i - patternLen + 1;
            }

        }
        return -1;
    }

    /**
     * 根据模式串得到next数组
     * next数组并不需要主串参与计算
     * @param pattern 模式串
     * @return
     */
    private int[] getNext(char[] pattern) {
        int len = pattern.length;
        int[] next = new int[len];
        //next数组的第一个元素一定是-1，因为找不到最长公共前后缀，这个时候只有前缀，没有后缀，因为只有一个元素
        next[0] = -1;

        int k = -1;


        //这个地方一定要注意，i是从开始的，不是从0开始的，next[0]肯定是-1，不用再算了
        //如果这个地方从0开始，肯定会出错
        for (int i = 1; i < len; i++) {

            //因为前一个的最长串的下一个字符不与最后一个相等，需要找前一个的次长串，问题就变成了求0到next(k)的最长串
            //如果下个字符与最后一个不等，继续求次长串，也就是下一个next(k)，直到找到，或者完全没有
            while (k != -1 && pattern[k + 1] != pattern[i]) {
                k = next[k];
            }

            if (pattern[k + 1] == pattern[i]) {
                k++;
            }

            next[i] = k;
        }

        return next;
    }


    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'a', 'c', 'a', 'b', 'd', 'c'};
        char[] b = {'a', 'b', 'd'};
        System.out.println(new KMP().KMPMatch(a, b));
    }
}
