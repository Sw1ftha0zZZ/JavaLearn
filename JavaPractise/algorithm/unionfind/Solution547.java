package algorithm.unionfind;

import java.util.Arrays;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/11
 */

public class Solution547 {
    public class UnionFind {
        //连通分量个数
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
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

            if (rank[pRoot] == rank[qRoot]) {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            }else {
                parent[pRoot] = qRoot;
            }

            //合并了count要减一
            count--;
        }
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        public int getCount() {
            return this.count;
        }
    }

    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
