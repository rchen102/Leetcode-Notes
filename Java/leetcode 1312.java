class Solution {
    public int minInsertions(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        // base cases
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // dp 推导
        for (int i = n-2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }
}