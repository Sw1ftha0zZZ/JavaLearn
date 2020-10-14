package algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/08/26
 */

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();

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

        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的点都入队
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }


        while (!queue.isEmpty()) {

            //弹出入度为0的点
            int visted = queue.poll();

            list.add(visted);

            for (int course : edges.get(visted)){
                //将和弹出节点关联的点的入度-1
                indegree[course]--;
                //如果-1后的入度为0，将节点入队
                if (indegree[course] == 0){
                    queue.offer(course);
                }
            }
        }

        if (list.size() == numCourses){
            int[] result = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }else {
            return new int[0];
        }

    }
}
