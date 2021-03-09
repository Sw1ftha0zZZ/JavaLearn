package interview.alibaba.cloud;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */



public class Solution implements StringHandler{
    @Override
    public String getLongestSubStrWithEquivalenceCharAndNumber(String str) {
        char[] chs = str.toCharArray();
        int[] numCount = new int[chs.length + 1];
        int[] otherCount = new int[chs.length + 1];

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                numCount[i + 1] = numCount[i] + 1;
                otherCount[i + 1] = otherCount[i];
            } else {
                numCount[i + 1] = numCount[i];
                otherCount[i + 1] = otherCount[i] + 1;
            }
        }

        int index = 0;
        int maxLen = 0;
        for (int i = 0; i <= chs.length; i++) {
            for (int j = i + maxLen + 1; j <= chs.length; j++) {
                if (numCount[j] - numCount[i] == otherCount[j] - otherCount[i] && 2 * (numCount[j] - numCount[i]) > maxLen) {
                    index = i;
                    maxLen = 2 * (numCount[j] - numCount[i]);
                }
            }
        }
        return str.substring(index, index + maxLen);

    }
    public static class StringHandlerTest {

        public static void main(String[] args) {

            Solution bean = new Solution();
            long start = System.currentTimeMillis();
            String result = bean.getLongestSubStrWithEquivalenceCharAndNumber("1231231aaa1234444bbmbmb34b");
            assertEquals(result, "1aaa1234444bbmbmb34b");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber("ddddd");
            assertEquals(result, "");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber("1b1b1b1b1");
            assertEquals(result, "1b1b1b1b");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber("1213123bbbbbbb");
            assertEquals(result, "1213123bbbbbbb");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber("aaaaa222aaa2222");
            assertEquals(result, "aaaa222aaa2222");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber(
                    "https://www.apsaraun.com/student/course/study/64450/67862");
            assertEquals(result, "se/study/64450/67862");
            //https://yuque.antfin.com/shengbo.tsb/fy8yt0/tbcqam#efLk
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber(
                    "https://yuque.antfin.com/shengbo.tsb/fy8yt0/tbcqam#efLk");
            assertEquals(result, "8yt0");
            result = bean.getLongestSubStrWithEquivalenceCharAndNumber(
                    "https://aone.alibaba-inc.com/v2/project/831025/req/21708190");
            assertEquals(result, "v2/project/831025/req/21708190");

//            result = bean.getLongestSubStrWithEquivalenceCharAndNumber("1a1a");
//            System.out.println(result);
            System.out.println("cost:" + (System.currentTimeMillis() - start));
        }

        static void assertEquals(String a, String b) {
            if (a == null && b == null) {
                System.out.println("true");
            }
            if (a.equals(b)) {
                System.out.println("true");
            } else {
                System.out.println("false");
                System.out.println("a="+a +" But b="+b);
            }
        }
    }
}
