// 从第 0 天开始，更不容易出错
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        
        int[][][] dp = new int[n+1][3][2];
        int minus_inf = Integer.MIN_VALUE >> 1;  // 防止减法 overflow
        // Base case：第 0 天，不允许交易
        for (int k = 0; k < 3; k++) {
            dp[0][k][0] = minus_inf;
            dp[0][k][1] = minus_inf;
        }
        dp[0][0][0] = 0;
        
        // dp 推导
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i-1]);
            }
        }
        
        int maxProfit = dp[n][2][0];
        for (int k = 0; k <= 2; k++) {
            maxProfit = Math.max(maxProfit, dp[n][k][0]);
        }
        return maxProfit;
    }
}

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