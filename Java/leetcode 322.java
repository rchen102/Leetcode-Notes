// Solution: dp T: O(n * k) S: O(n)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (dp[i - coin] >= 0) {
                    minCount = Math.min(minCount, dp[i - coin] + 1);
                }
            }
            dp[i] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        }
        return dp[amount];
    }
}