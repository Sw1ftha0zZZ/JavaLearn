package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 *
 * 本题数组中无重复元素
 * 而且candidates 中的数字可以无限制重复被选取
 */

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, temp, result);
        return result;
    }

    public void dfs(int[] candidates, int target, int pos, List<Integer> temp, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<> (temp));
            return;
        }

        for (int i = pos; i < candidates.length; ++i) {

            //这个判断很重要，要target还能再减去candidates[pos]才行，而不是还能减去candidates[i]
            if (target < candidates[pos]){
                break;
            }


            temp.add(candidates[i]);
            //因为这个题中candidates 中的数字可以无限制重复被选取。
            //所以这个地方dfs的pos传进来的是i，而不是i + 1
            dfs(candidates, target - candidates[i], i, temp, result);
            temp.remove(temp.size() - 1);
        }

    }
}
