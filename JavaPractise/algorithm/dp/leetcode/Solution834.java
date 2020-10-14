package algorithm.dp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/06
 *
 * 树形dp
 */

public class Solution834 {

    int[] ans;
    //以该结点(i)为根结点的子树的结点数目（包括根自己）
    int[] nodeNum;
    //以该结点(i)为根的子树，它的所有子节点到它的距离之和
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        nodeNum = new int[N];
        dp = new int[N];
        graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //建图，graph可以当作二维数组看待，get(u)会定位到索引为u的list
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //先把nodeNum数组都求出来
        dfs(0, -1);
        //执行换根操作求每个结点的dp值
        dfs2(0, -1);

        return ans;
    }

    //因为图中的边都会与父节点相连，求得时候要跳过父节点的情况，所以要把father也作为参数传进去
    public void dfs(int root, int father) {
        //自己就是一个结点
        nodeNum[root] = 1;
        dp[root] = 0;

        //所有和root相连的点（包括父节点）
        for (int child : graph.get(root)) {
            if (child == father) {
                continue;
            }

            dfs(child, root);
            //把有叶子结点的dp先求出来
            dp[root] += dp[child] + nodeNum[child];
            nodeNum[root] += nodeNum[child];
        }
    }

    public void dfs2(int root, int father) {

        //保存上一次换根后的结果（对于root为0的情况，保存的是之前完整dfs一遍的结果）
        ans[root] = dp[root];
        for (int child: graph.get(root)) {
            if (child == father) {
                continue;
            }
            //保存换根前的信息
            int pr = dp[root];
            int pc = dp[child];
            int nr = nodeNum[root];
            int nc = nodeNum[child];

            //换根
            dp[root] -= dp[child] + nodeNum[child];
            nodeNum[root] -= nodeNum[child];
            dp[child] += dp[root] + nodeNum[root];
            nodeNum[child] += nodeNum[root];

            //继续对root的child的child换根
            dfs2(child, root);

            //恢复换根前的，找下一个child进行新的换根
            dp[root] = pr;
            dp[child] = pc;
            nodeNum[root] = nr;
            nodeNum[child] = nc;
        }
    }

}
