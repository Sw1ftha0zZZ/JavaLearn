package algorithm.tree.book;
import	java.util.HashMap;
import	java.util.Map;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/07/23
 * 通过先序和中序数组生成后序数组
 * 已经二叉树的所有节点值都不同
 *
 * 过程总结为：根据当前的先序和中序数组，设置后序数组最右边的值，
 * 然后划分出左子树的先序，中序数组，以及右子树的先序中序数组
 * 先根据右子树的划分设置好后序数组，再根据左子树的划分，从右到左依次设置好后序数组的全部位置
 */

public class PreIn2Post {
    public int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null){
            return null;
        }
        int len = pre.length;
        int[] post = new int[len];
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < len; ++i) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, post, len - 1, map);
        return post;
    }
    //从右往左依次填好后序数组s
    //si为后序数组s该填的位置
    //返回值为s该填的下一个位置
    public int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj,
                      int[] s, int si, Map<Integer, Integer> map){
        if (pi > pj){
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, s, si, map);
        return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, s, si, map);
    }

}
