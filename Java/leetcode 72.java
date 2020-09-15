// Solution: 基本 dp T: O(mn) S: O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 != null) return word2.length();
        if (word2 == null && word1 != null) return word1.length();
        if (word1 == null && word2 == null) return 0;
        
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        // base case
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // 跳过操作，什么也不做
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1); // 插入或者删除操作
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);  // 替换操作
                }
            }
        }
        return dp[n1][n2];
        
    }
}