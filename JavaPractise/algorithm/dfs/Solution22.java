package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 *
 * 这个题其实是剪枝的思路，只对满足条件的做递归
 * 每次做dfs的时候先判断
 * 最后只要长度合适就一定可以
 */

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, "", result);
        return result;
    }

    //left是还能再加的左括号的数量
    //right是还能再加的右括号的数量
    public void dfs(int left, int right, String temp, List<String> result){
        if (left == 0 && right == 0){
            result.add(temp);
            return;
        }

        //左括号的剩余数量大于0
        if (left > 0){
            dfs(left - 1, right, temp + "(", result);
        }

        //右括号的剩余数量大于左括号的
        if (right > left){
            dfs(left, right - 1, temp + ")", result);
        }

    }
}
