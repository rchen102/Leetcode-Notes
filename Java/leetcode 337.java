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

// O(n)
class Solution {

    HashMap<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return rob_dp(root);
    }

    public int rob_dp(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int do_it = root.val +
            (root.left == null ? 0 : rob_dp(root.left.left) + rob_dp(root.left.right)) +
            (root.right == null ? 0 : rob_dp(root.right.left) + rob_dp(root.right.right));
        int not_do = rob_dp(root.left) + rob_dp(root.right);
        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}