// Solution: 基本 dp T: O(2n) S: O(nk2)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int k_max = 2;
        int[][][] dp = new int[n][k_max+1][2];
        // base case
        for (int k = 0; k <= k_max; k++) {
             dp[0][k][0] = Integer.MIN_VALUE >> 1;
             dp[0][k][1] = Integer.MIN_VALUE >> 1;
        }        
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
       
        // dp
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= k_max; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                if (i == n-1) {
                    res = Math.max(res, dp[i][k][0]);
                }
            }
        }
        return res;
    }
}