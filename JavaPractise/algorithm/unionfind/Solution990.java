package algorithm.unionfind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/14
 */

public class Solution990 {
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

    public boolean equationsPossible(String[] equations) {

        UnionFind uf = new UnionFind(26);

        for (String text: equations) {
            if (text.charAt(1) == '=') {
                uf.union(text.charAt(0) - 'a', text.charAt(3) - 'a');
            }
        }

        for (String text: equations) {
            if (text.charAt(1) == '!') {
                if (uf.isConnected(text.charAt(0) - 'a', text.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }



    //繁琐的版本，其实这两个list没必要创建的，只要for循环遍历两次就好了
    public boolean equationsPossible1(String[] equations) {
        List<String> equals = new LinkedList<>();
        List<String> notEqual = new LinkedList<>();

        UnionFind uf = new UnionFind(26);

        for (String text: equations) {
            if (text.charAt(1) == '!') {
                notEqual.add(text);
            }else {
                equals.add(text);
            }
        }

        for (String text: equals) {
            uf.union(text.charAt(0) - 'a', text.charAt(3) - 'a');
        }

        for (String text: notEqual) {
            if (uf.isConnected(text.charAt(0) - 'a', text.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }
}
