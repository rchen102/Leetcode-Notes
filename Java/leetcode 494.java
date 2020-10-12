// Solution1: backtrack  T: O(2^n) S: O(n)
class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        backtrack(0, nums, 0, S);
        return result;
    }
    
    private void backtrack(int curSum, int[] nums, int idx, int S) {
        if (idx == nums.length) {
            if (curSum == S) result++;
            return;
        }
        // 选择 +
        backtrack(curSum + nums[idx], nums, idx+1, S);

        // 选择 -
        backtrack(curSum - nums[idx], nums, idx+1, S);
    }
}

// backtrack 中会遇到重复的子问题，备忘录优化
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dp(nums, 0, S);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    int dp(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }

        String key = i  + "," + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dp(nums, i+1, remain-nums[i]) + dp(nums, i+1, remain + nums[i]);
        memo.put(key, res);
        return res;
    }
}

// 问题转换为子集背包
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + S) % 2 != 0) return 0;
        int weight = (sum + S) / 2;
        // 子集背包问题
        // dp[i][j]  前 i 个物品，装满 j 的装法总数
        // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]] 
        int n = nums.length;
        int[][] dp = new int[n+1][weight+1];

        // base case
        // dp[0][.] 前 0 个物品，装法为 0
        // dp[.][0] 不装即可，一种装法
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // dp 推导
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][weight];
    }
}