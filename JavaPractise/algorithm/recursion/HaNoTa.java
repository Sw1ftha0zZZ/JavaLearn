package algorithm.recursion;

import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/10
 */

public class HaNoTa {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int len = A.size();
        hanotaHelper(len, A, B, C);
    }
    private void hanotaHelper(int num, List<Integer> original, List<Integer> helper, List<Integer> target) {

        //递归出口，只剩一个的时候，直接从ori移动到tar
        if (num == 1) {
            target.add(original.remove(original.size() - 1));
            //不要忘记这句话
            return;
        }

        //将ori上面的num-1借助target移动到helper上
        hanotaHelper(num - 1, original, target, helper);
        //将ori上剩下的一个直接移动到tar上
        target.add(original.remove(original.size() - 1));
        //借助ori将helper上的num-1个移动到tar上
        hanotaHelper(num - 1, helper, original, target);
    }
}
