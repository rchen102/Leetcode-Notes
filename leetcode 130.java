//Solution1: union find  T: O(mn) S: O(mn)
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
        
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(i * cols + j, dummyNode);
                    }
                    else {
                        int id1 = i * cols + j;
                        for(int[] d : distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if(board[x][y] == 'O') {
                                int id2 = x * cols + y;
                                uf.union(id1, id2);
                            }
                        }
                    }  
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int id = i * cols + j;
                if(uf.isConnected(id, dummyNode)) {
                    board[i][j] = 'O';
                }
                else
                    board[i][j] = 'X';
            }
        } 
    }
}

class UnionFind {
    int[] father;
    
    UnionFind(int length) {
        father = new int[length];
        for(int i = 0; i < length; i++) {
            father[i] = i;
        }
    }
    
    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }
    
    public int find(int node) {
        if(node == father[node]) return father[node];
        father[node] = find(father[node]);
        return father[node];
    }
    
    public void union(int node1, int node2) {
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2) {
            father[find2] = find1;
        }       
    }   
}

//Solution3: union find T: O(n) S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        UnionFind uf = new UnionFind(length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                if(map.containsKey(nums[i]-1)) {
                    uf.union(i, map.get(nums[i]-1));
                }
                if(map.containsKey(nums[i]+1)) {
                    uf.union(i, map.get(nums[i]+1));
                }
            }
        }
        return uf.maxUnion();

    }
}

class UnionFind {
    int[] father;
    
    UnionFind(int length) {
        father = new int[length];
        for(int i = 0; i < length; i++) {
            father[i] = i;
        }
    }
    
    public int maxUnion() {
        int[] count = new int[father.length];
        int res = 0;
        for(int i = 0; i < father.length; i++) {
            count[find(i)]++;
            res = Math.max(res, count[father[i]]);
        }
        return res;
    }
    
    public int find(int node) {
        if(node == father[node]) return father[node];
        father[node] = find(father[node]);
        return father[node];
    }
    
    public void union(int node1, int node2) {
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2) {
            father[find2] = find1;
        }       
    }   
}