// Solution1: 衍生法，少有的，暴力比 dp 更好 T: O(n^2) S: O(1)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String r1 = findPalindrome(s, i, i);
            String r2 = findPalindrome(s, i, i+1);
            if (r1.length() > res.length()) res = r1;
            if (r2.length() > res.length()) res = r2;
        }
        return res;
       
    }
    
    public String findPalindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }
            else {
                break;
            }
        }
        return str.substring(l+1, r);
    }
}

// Solution: dp T: O(n^2) S: O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 推导
        String res = "";
        int maxLen = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (j - i == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    dp[i][j] = (dp[i+1][j-1] && (s.charAt(i) == s.charAt(j)));
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j+1);
                }
            }
        }
        if (maxLen != 0) return res;
        return String.valueOf(s.charAt(0));
    }
}