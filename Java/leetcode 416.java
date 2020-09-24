// Solution: 基本 dp  T: O(nk) S: O(nk) k = sum(nums)  
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        
        // base cases
        // 1. 可选物品为 0，背包也为 0
        dp[0][0] = true;
        // 2. 可选物品为 0，背包不为 0，默认 false        
        // 3. 可选物品不为 0，背包为 0，都为 true
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // dp 推导
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 注意这里是小于，大于等于都可以
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}

// 优化：状态压缩
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int len = nums.length;
        // 如果和为奇数，肯定分不了
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum = sum/2;
        
        // 初始化 Base case
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
      
        // 状态转移
        for (int i = 1; i <= len; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }
        }
        return dp[sum];
    }
}