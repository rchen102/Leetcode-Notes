// Solution: 基本 dp  T: O(nk) S: O(nk) k = sum(nums)  
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int len = nums.length;
        // 如果和为奇数，肯定分不了
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum = sum/2;
        
        // 初始化 Base case
        boolean[][] dp = new boolean[len+1][sum+1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        // 物品为 0 时，无物品可装，注意 dp[0][0] = true
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
        // 状态转移
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                // 背包容量不足
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[len][sum];
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