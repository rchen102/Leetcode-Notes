// Solution: 基本 dp T: O(mn) S: O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        String s = word1, t = word2;
        if (s == null && t == null) return 0;
        if (s == null && t != null) return t.length();
        if (s != null && t == null) return s.length();
        
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        dp[0][0] = 0;
        // dp 推导
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 1. 相等，什么都不用做
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    // 2. s 插入字符
                    dp[i][j] = dp[i][j-1] + 1;
                    
                    // 3. 删除 s 字符
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                    
                    // 4. 替换字符
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[n][m];
        
    }
}

// dp[i][j] s[1..i] 和 t[1..j] 的编辑距离
// 可以选择的操作：插入，删除，替换，什么都不做
// if s[i] == t[j], dp[i][j] = dp[i-1][j-1]  // 什么都不做
// else  dp[i][j] = 1 + Math.min(
//     dp[i-1][j]   // 删除
//     dp[i][j-1]   // 插入
//     dp[i-1][j-1] // 替换
// ) 