class UnionFind {
    int[] parent;
    
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
        parent[rootq] = rootp;
    }
    
    boolean connected(int p ,int q) {
        return find(p) == find(q);
    }
}

// Solution1: unionfind  T: O(n) S: O(1)
class Solution {
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) return true;
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                char x = str.charAt(0);
                char y = str.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        
        // 判断是否有矛盾
        for (String str : equations) {
            if (str.charAt(1) != '=') {
                char x = str.charAt(0);
                char y = str.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) return false;
            }
        }
        return true;
    }
}