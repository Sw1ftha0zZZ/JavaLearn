package interview.alibaba.cloud;

/**
 * <p>
 *     计算由英文字符和数字构成的字符串内最长的、包含相同长度的数字和非数字的子字符串。
 *      <ul>如果有多个这样的字符串，则返回最左边的</ul>
 *      <ul>如果没有，则返回空串 ""</ul>
 * </p>
 * <p>
 *     比如:
 *     <ul>"aaadasdfasdfasdfa111bbb"，则返回"dfa111"</ul>
 *     <ul>"aaaaaa", 则返回"" </ul>
 * </p>
 * <p>
 *     要求：
 *     <ul>1. 实现此接口</ul>
 *     <ul>2. 充分考虑最优性能，能够清晰解释性能复杂度</ul>
 *     <ul>3. 写UT证明代码正常工作</ul>
 * </p>
 * @author wenfeng.jiang
 */
public interface StringHandler {

    /**
     *  计算由英文字符和数字构成的字符串内最长的、包含相同长度数字和非数字的子字符串
     *
     * @param str 由英文和数字构成的字符串
     * @return String 最长的、包含相同长度的数字和字母的子字符串
     */
    String getLongestSubStrWithEquivalenceCharAndNumber(String str);
}