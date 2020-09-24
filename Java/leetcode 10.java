// Solution: dp T： O(nm) S: O(nm)
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return s == p;
        int n = s.length(), m = p.length();
        
        // dp tables
        boolean[][] dp = new boolean[n+1][m+1];
        
        // base cases
        // 1. p 是空串, dp[i][0] = false，默认初始化已经是 false 了       
        // 2. 两个都为空串
        dp[0][0] = true;
        // 3. s 是空串，p 是 #*#*#*#*...
        for (int j = 2; j <= m; j = j+2) {
            if (p.charAt(j-1) == '*' && dp[0][j-2]) {
                dp[0][j] = true;
            }
        }
        
        // dp 推导
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 1. 正好相等，或者 p 是 . 匹配任意一个
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    // 2. 完全不匹配
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    }
                    else {
                        // 3. 匹配 0 个 或者 N 个
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}