class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m < 1 || n < 1)
            return 0;
        
        int[][] res = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) {
                    res[i][j] = grid[i-1][j-1];
                    continue;
                }
                
                if(i == 1) {
                    res[i][j] = res[i][j-1] + grid[i-1][j-1];
                    continue;
                }
                    
                if(j == 1) {
                    res[i][j] = res[i-1][j] + grid[i-1][j-1];
                    continue;
                }
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i-1][j-1];
            }
        }
        return res[m][n];
    }
}