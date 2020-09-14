// Solution: 基本 dp   T: O(nk) S: O(nk) k=amount
class Solution {
        
    public int change(int amount, int[] coins) {
        if (coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 没有硬币可用，找零方案为 0
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        // 总额为 0，找零方案为 1，即不用找零
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        // 状态转移
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i-1][j];
                if (j >= coins[i-1]) {
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}


// Solution: backtrack  不需要使用，只是复习下回溯写法，太慢了会超时
class Solution {
    
    int res = 0;
    
    public int change(int amount, int[] coins) {
        if (coins == null) return 0;
        if (amount == 0 && coins.length == 0) return 1;
        backtrack(coins, 0, 0, amount);
        return res;
    }
    
    private void backtrack(int[] coins, int idx, int curSum, int target) {
        if (curSum == target) {
            res++;
            return;
        }
        
        for (int i = idx; i < coins.length; i++) {
            if (curSum + coins[i] > target) continue;
            backtrack(coins, i, curSum + coins[i], target);
        } 
    }
}