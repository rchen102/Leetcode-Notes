// Solution: 基本 dp T: O(n) S: O(n) (可以状态压缩优化 S：O(1))
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
  
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            if (i >= 2) {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            } else {
                // dp[-1][] = 0，交易还未开始，该状态不可能存在
                dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i]);
            }
        }
        return dp[n-1][0];
    }
}