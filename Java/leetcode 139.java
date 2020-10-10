//Solution1: DP T:O(n * maxLen) S: O(k) k = size of wordDict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Build dictionary map
        HashSet<String> dict = new HashSet<>();
        int maxLen = 0;
        for (String str : wordDict) {
            dict.add(str);
            maxLen = Math.max(maxLen, str.length());
        } 
        // dp[i]: s[1..i] is valid or not
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        // base case
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int left = Math.max(0, i - maxLen); 
            for (int j = i-1; j >= left; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}