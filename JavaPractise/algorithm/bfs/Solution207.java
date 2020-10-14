package algorithm.bfs;
import	java.util.LinkedList;
import	java.util.Queue;
import java.util.*;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/26
 *
 * [0,1]表示想要学习课程 0 ，你需要先完成课程 1
 * 也就是说0依赖于1，1指向0，修完1就可以修0了
 */

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化边
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //入度
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites){
            //谁指向谁不要写反了

            //把1指向0
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //0的入度+1
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<> ();
        //将入度为0的点都入队
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        //修的课程数
        int count = 0;
        while (!queue.isEmpty()) {

            //弹出入度为0的点
            int visted = queue.poll();
            //修的课程数+1
            count++;
            for (int course : edges.get(visted)){
                //将和弹出节点关联的点的入度-1
                indegree[course]--;
                //如果-1后的入度为0，将节点入队
                if (indegree[course] == 0){
                    queue.offer(course);
                }
            }
        }

        return count == numCourses;
    }


}
