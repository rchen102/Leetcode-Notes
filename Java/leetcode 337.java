// Solution: 基本 dp T:O(n) S: O(n)
class Solution {
    public int rob(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }
    
    // dp[0]: 代表选择不抢当前这个房子
    // dp[1]: 代表抢当前这个房子的结果
    public int[] dp(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 不抢，则left 和 right 可抢可不抢
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢，left 和 right 都不能抢
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
}