// Solution1: sliding window T: O(n) S: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        // helper variables
        int[] code = new int[26];
        for (char ch : p.toCharArray()) {
            code[ch-'a'] += 1;
        }
        // sliding window
        int windowLen = p.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            code[ch-'a'] -= 1;
            
            if (i >= windowLen) {
                char leave = s.charAt(i-windowLen);
                code[leave-'a'] += 1;
            }
            if (isAllZero(code)) res.add(i-windowLen+1);
        }
        return res;
    }
    
    private boolean isAllZero(int[] code) {
        for (int i = 0; i < code.length; i++) {
            if (code[i] != 0) return false;
        }
        return true;
    }
}