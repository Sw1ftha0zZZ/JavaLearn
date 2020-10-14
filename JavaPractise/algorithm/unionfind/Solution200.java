package algorithm.unionfind;


/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/12
 * 这个题的启示是uf不能直接默写模板，还是要根据题意改一下的
 * 这个题要把二维的坐标转化为一维的
 *
 * 另外不要忘了在二维grid中使用方向数组
 */

public class Solution200 {
    public class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;


        /**
         * uf的创建一定不要死板，要根据题意写uf，比如这个题uf的构造函数可以传入grid作为参数
         * @param grid
         */
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        rank[i * n + j] = 1;
                        count++;
                    }
                }
            }
        }
        public int find (int p) {
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
        public boolean isConnected (int p, int q) {
            return find(p) == find(q);
        }
        public int getCount() {
            return count;
        }
    }

    /**
     * 将二维坐标转换为一维坐标
     * @param x
     * @param y
     * @param cols
     * @return
     */
    public int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    public boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];

                        if (inArea(newRow, newCol, rows, cols) && grid[newRow][newCol] == '1') {
                            uf.union(getIndex(i, j, cols), getIndex(newRow, newCol, cols));
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }

}
