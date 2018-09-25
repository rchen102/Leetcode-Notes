//Solution1: DP T:O(n^2 * m) S: O(n)  m: the length of the dict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(f[j] && wordDict.contains(s.substring(j, i)))
                    f[i] = true;
            }
        }
        return f[s.length()];
    }
}