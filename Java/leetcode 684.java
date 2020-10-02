// Solution1: Union find T: O(n) S: O(n)
class UnionFind {
    int parent[];
    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        parent[rootp] = rootq;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        if (edges == null || edges.length == 0 || edges[0] == null) return res;
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);
        for (int i = 0; i < n; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            if (uf.connected(p, q)) res = edges[i];
            else uf.union(p, q);
        }
        return res;
    }
}