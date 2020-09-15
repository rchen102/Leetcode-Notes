// Solution: 基本dp T: O(n) S: O(n)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        // base cases
        dp[n] = 0;
        dp[n-1] = nums[n-1];
        // dp
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[0];
    }
}

// 状态压缩 T: O(n) S: O(1)
class Solution {
    public int rob(int[] nums) {
        int preMax = 0, curMax = 0;
        for(int j = 0; j < nums.length; j++) {
            int t = curMax;
            curMax = Math.max(preMax+nums[j], curMax);
            preMax = t;
        }
        return curMax;
    }
}