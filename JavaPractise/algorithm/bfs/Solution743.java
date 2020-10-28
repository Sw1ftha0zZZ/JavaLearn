package algorithm.bfs;
import	java.util.PriorityQueue;
import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/26
 *
 * Dijkstra
 *
 * times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 *
 * 2到1权重为1，2到3权重为1...
 */

public class Solution743 {
    public int networkDelayTime(int[][] times, int N, int K) {


        //根据times数组，构建图
        //这里用Map构建图是因为要存放权重
        //对于同一个K，V是用链表连起来的
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times){
            if (!graph.containsKey(time[0])){
                graph.put(time[0], new ArrayList<int[]>());
            }
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        //PQ实现Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});

        //访问过的节点集合
        Map<Integer, Integer> visited = new HashMap<> ();

        while (!pq.isEmpty()){
            int[] cur = pq.poll();

            int node = cur[0];
            int weight = cur[1];

            //如果访问过这个节点，那就跳过
            if (visited.containsKey(node)){
                continue;
            }

            visited.put(node, weight);

            //要保证有边出来，比如例题中的节点1就是没有出来的边的，对1就做不了下面的操作，所以要加上这个if判断
            if (graph.containsKey(node)){

                //对所有和当前节点相连接的点操作
                for (int[] next : graph.get(node)){
                    //如果和当前节点连接的点没被访问过，更新它的weight，并入队
                    if (!visited.containsKey(next[0])){

                        pq.offer(new int[]{next[0], weight + next[1]});

                    }

                }
            }
        }


        if (visited.size() != N){
            return -1;
        }

        int result = 0;
        for (int num: visited.values()){
            result = Math.max(result, num);
        }

        return result;
    }
}
