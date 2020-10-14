package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/09/05
 */

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(int i, int n, int k, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j <= n; j++) {
            tmp.add(j);
            backtrack(j + 1, n, k - 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
