// Solution1: union find  T: O(mn) S: O(mn)
class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        parent[rootp] = rootq;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;
        
        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        
        // 遍历棋盘
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    uf.union(i * m + j, dummy);
                }
                else {
                     // 与上下左右 'O' 相连
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (board[x][y] == 'O') {
                            uf.union(x * m + y, i * m + j);
                        }
                    }
                }
            }
        }
        
        // 开始替换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !uf.connected(i * m + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

// Solution2: dfs  T：O(mn) S: O(1)
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;
        
        // 第一列和最后一列
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][m-1] == 'O') dfs(i, m-1, board);
        }
        // 第一行和最后一行
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[n-1][j] == 'O') dfs(n-1, j, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' ) board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public static void dfs(int x, int y, char[][] board) {
        if (!checkBoundary(x, y, board.length, board[0].length)) return;
        if (board[x][y] != 'O') return;
        board[x][y] = '#';
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];
            dfs(nextX, nextY, board);
        }
    }
    
    public static boolean checkBoundary(int x, int y, int n, int m) {
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
        return true;
    } 
}


// Solution3: bfs  T: O(mn) S: O(mn)
class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length;
        int m = board[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        // 第一列和最后一列
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') queue.offer(new Node(i, 0));
            if (board[i][m-1] == 'O') queue.offer(new Node(i, m-1));
        }
        // 第一行和最后一行
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') queue.offer(new Node(0, j));
            if (board[n-1][j] == 'O') queue.offer(new Node(n-1, j));
        }
        // bfs 遍历
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            board[x][y] = '#';
            for (int k = 0; k < 4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];
                if (!checkBoundary(nextX, nextY, n, m)) continue;
                if (board[nextX][nextY] == 'O') {
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' ) board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public static boolean checkBoundary(int x, int y, int n, int m) {
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
        return true;
    } 
}