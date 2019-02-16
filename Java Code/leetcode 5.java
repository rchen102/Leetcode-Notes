// Solution1: T: O(n^2) S: O(1)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int len1 = extend(s, i, i); // assume odd length, try to extend palindrome as possible
            int len2 = extend(s,i, i+1); // assume enven length
            if (Math.max(len1, len2) > max) {
                // Update 
                max = Math.max(len1, len2);
                idx = len1 > len2 ? (i - len1/2) : (i - len2/2 + 1);
            }
        }
        return s.substring(idx, idx + max);
    }
    
    private int extend(String s, int i, int j) {
        int len = s.length();
        for (; i >= 0 && j < len; i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return j - i + 1 -2; // Current 2 unmatched chars
    }
}

// Solution2: Dynamic Programming T: O(n^2) S: O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        for (int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if (j - i <= 2) dp[i][j] = (s.charAt(i) == s.charAt(j));
                else dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                if (dp[i][j] && res.length() < j - i + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}