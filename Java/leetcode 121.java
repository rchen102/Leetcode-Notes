// Solution: dp 状态机 从第 0 天开始 
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        
        int[][] dp = new int[n+1][2];
        int minus_inf = Integer.MIN_VALUE;
        // base case
        // 第 0 天，不可能持有股票
        dp[0][0] = 0;
        dp[0][1] = minus_inf;
        // dp 推导
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i-1]);
        }
        return dp[n][0];
    }
}


// Solution: dp 状态机模型(从第一天开始) T: O(n) S: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        return dp[n-1][0];
    }
}

// 状态压缩优化  T: O(n) S: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        
        int keep = 0;
        int buy = -prices[0];
        
        for (int i = 1; i < n; i++) {
            keep = Math.max(keep, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return keep;
    }
}


// Solution: dp 转换为求最大子数组和的问题 T: O(n) S: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i+1] - prices[i];
        }
        int res = findMaxSubarray(diff);
        return res > 0 ? res : 0;
    }
    
    int findMaxSubarray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}