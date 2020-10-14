package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 */

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
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
            if (target < candidates[pos]){
                break;
            }
            if (i > pos && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);

            //因为这个题中candidates 中的每个数字在每个组合中只能使用一次。
            //所以这个地方dfs的pos传进来的是i + 1
            dfs(candidates, target - candidates[i], i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }

    }
}
