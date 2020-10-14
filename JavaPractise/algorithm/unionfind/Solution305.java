package algorithm.unionfind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/14
 */

public class Solution305 {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            count = 0;
            parent = new int[n];
            rank = new int[n];

            //因为还不知道land加在哪，parent先赋值为-1
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            //路径压缩
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            }else if (rank[qRoot] > rank[pRoot]) {
                parent[pRoot] = qRoot;
            }else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }

            count--;
        }

        public int getCount() {
            return count;
        }

        public boolean isValid(int p) {
            return parent[p] != -1;
        }

        //根据添加做初始化
        public void setParent(int p) {
            if (parent[p] != p) {
                count++;
            }
            parent[p] = p;
        }
    }

    //方向数组
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //判断新的索引是否越界
    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        char[][] grid = new char[m][n];
        List<Integer> ans = new LinkedList<>();

        //将二维坐标转化为一维坐标，所以初始化m * n个
        UnionFind uf = new UnionFind(m * n);

        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];

            //当前加入的位置，把这个二维坐标转化为一维坐标
            int index = row * n + col;
            //初始化加入位置的parent数组
            uf.setParent(index);

            //检查周围是否有陆地
            List<Integer> around = new LinkedList<>();

            for (int[] direction : directions) {
                int newX = row + direction[0];
                int newY = col + direction[1];

                if (inArea(newX, newY, m, n) && uf.isValid(newX * n + newY)) {
                    around.add(newX * n + newY);
                }
            }

            //union当前的和周围的
            for (int round : around) {
                uf.union(index, round);
            }

            ans.add(uf.getCount());
        }

        return ans;
    }
}
