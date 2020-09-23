class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return s == p;
        // dp table
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        // base case
        dp[0][0] = true;
        for (int j = 0; j < len2; j++) {
            if (p.charAt(j) == '*' && dp[0][j-1]) {
                dp[0][j+1] = true;
            }
        }
        
        // dp 推导
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*') {
                    // 匹配 0 次
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    }
                    else {
                        // 匹配 0 或 n 次
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}