// Solution: 基本 dp  T: O(n) S: O(n) (可以状态压缩至 O(1))
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base cases
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // dp
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}


//Solution1: T: O(n) S: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0, diff = 0;
        for(int i = 1; i < prices.length; i++) {
            if((diff = prices[i] - prices[i-1]) > 0)
                sum += diff;
        }
        return sum;
    }
}