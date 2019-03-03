//Own solution: DP T: O(mn) S: O(mn)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        
        int[][] res = new int[m][n];
        res[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j != 0) {
                    if(obstacleGrid[i][j] == 1) res[i][j] = 0;
                    else res[i][j] = res[i][j-1];
                }
                if(j == 0 && i != 0) {
                    if(obstacleGrid[i][j] == 1) res[i][j] = 0;
                    else res[i][j] = res[i-1][j];
                }
                if(i != 0 && j != 0) {
                    if(obstacleGrid[i][j] == 1) res[i][j] = 0;
                    else res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
}

//Solution1: DP T: O(mn) S: O(n)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}