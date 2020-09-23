// Solution: bfs T: O(n) S: O(n)
class Solution {
    
    class Node {
        int row;
        int col;
        int step;
        int obs;
        
        public Node(int row, int col, int step, int obs) {
            this.row = row;
            this.col = col;
            this.step = step;
            this.obs = obs;
        }
    }
    
    public int shortestPath(int[][] grid, int k) {
        if (grid == null) return -1;
        int n = grid.length;
        if (grid[0] == null) return -1;
        int m = grid[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(0, 0, 0, 0);
        queue.offer(start);
        
        Node[][] visited = new Node[n][m];
        visited[0][0] = start;
        
        // 移动方向
        int[] dx = new int[]{-1, 1, 0 , 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node tmp = queue.poll();
                int row = tmp.row;
                int col = tmp.col;
                int step = tmp.step;
                int obs = tmp.obs;
                if (row == n-1 && col == m-1) {
                    return step;
                }
                // four direction
                for (int j = 0; j < 4; j++) {
                    int newRow = row + dx[j];
                    int newCol = col + dy[j];
                    
                    if (!checkBoundary(newRow, newCol, n, m)) continue;
                    int newObs = obs + (grid[newRow][newCol] == 1 ? 1 : 0);
                    if (newObs > k) continue;
                    Node newNode = new Node(newRow, newCol, step+1, newObs);
                    // 第一次遍历
                    if (visited[newRow][newCol] == null) {
                        visited[newRow][newCol] = newNode;
                        queue.offer(newNode);
                    } else {
                        // 不是第一次遍历该结点，但是新路线障碍物更少
                        if (newObs < visited[newRow][newCol].obs) {
                            visited[newRow][newCol] = newNode;
                            queue.offer(newNode);
                        }
                    }
                }
            }
        }
        return -1;
        
    }
    
    public static boolean checkBoundary(int row, int col, int n, int m) {
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
}