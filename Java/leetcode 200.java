//Solution1: union find T: O(mn) S: O(mn)
class UnionFind {
    int[] parent;
    int count;
    
    UnionFind(int n) {
        count = n;
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
        count--;
    }
    
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
      
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int sumZero = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '1') {
                    sumZero++;
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0) continue;
                    if (x >= n || y >= m) continue;
                    if (grid[x][y] != '1') continue;
                    uf.union(i * m + j, x * m + y);                    
                }
            }
        }
        return uf.count - sumZero;
    }
}


//Solution1: dfs T: O(mn) S: O(m+n)（递归栈最大深度）
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int num = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    helper(i, j, grid);
                }
            }
        }
        return num;      
    }
    
    private void helper(int i, int j, char[][] grid) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') return;
        grid[i][j] = '0';
        helper(i + 1, j, grid);
        helper(i, j + 1, grid);
        helper(i - 1, j, grid);
        helper(i, j - 1, grid);
        
    }
}


