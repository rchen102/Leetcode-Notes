// Solution: 基本 dp T: O(n) S: O(n) (可以状态压缩优化 S：O(1))
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        
        int[][] dp = new int[n+1][2];
        // Base cases: 第 0 天，不允许交易
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        // dp 推导
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            if (i-2 < 0) dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i-1]);
            else dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i-1]);
            
        }
        return dp[n][0];
    }
}