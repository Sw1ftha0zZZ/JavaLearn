package algorithm.string.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/26
 */

public class JZOffer5 {
    public String replaceSpace(String s) {
        int length = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                ans.append("%20");
            }else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
