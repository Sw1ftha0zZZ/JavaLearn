import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class Test1 {

    public String combinationSum2(int[] candidates, int target, int m) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return "NO";
        }

        for (int candidate : candidates) {
            target = target - candidate;
        }

        // 关键步骤
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);

        int steps = Math.min(len, m);
        for (List<Integer> temp : res) {
            if (temp.size() == steps) {
                return "YES";
            }
        }
        return "NO";
    }


    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i]^3 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - (candidates[i] * candidates[i] * candidates[i] - candidates[i]) < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - (candidates[i] * candidates[i] * candidates[i] - candidates[i]), path, res);

            path.removeLast();
        }
    }

    public static void main(String[] args) {

        int[] candidates = new int[]{1, 1, 1, 1};
        int target = 4;
        Test1 solution = new Test1();
        System.out.println(solution.combinationSum2(candidates, target, 4));

    }
}
