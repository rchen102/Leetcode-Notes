// Solution1: sliding window T: O(n) S: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0 || s1 == null || s1.length() == 0) return false;
        // helper variables
        int[] code = new int[26];
        for (char ch : s1.toCharArray()) {
            code[ch-'a'] += 1;
        }
        
        // sliding window
        int windowLen = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            code[ch-'a'] -= 1;
            if (i >= windowLen) {
                char leave = s2.charAt(i - windowLen);
                code[leave-'a'] += 1;   
            }
            if (isAllZero(code)) return true;
        }
        return false;
    }
    
    private boolean isAllZero(int[] code) {
        for (int i = 0; i < code.length; i++) {
            if (code[i] != 0) return false;
        }
        return true;
    }
}

// Solution1: sliding window T: O(n) S: O(n)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0 || s1 == null || s1.length() == 0) return false;
        // helper variables
        char[] code = new char[26];
        for (char ch : s1.toCharArray()) {
            code[ch-'a'] += 1;
        }
        String need = String.valueOf(code);
        code = new char[26];
        
        // sliding window
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            
            code[ch-'a'] += 1;
            if (right - left == s1.length()) isNeedShrink = true;
            
            while (isNeedShrink) {
                if (need.equals(String.valueOf(code))) return true;
                
                char leave = s2.charAt(left);
                left++;
                
                code[leave - 'a'] -= 1;
                if (right - left < s1.length()) isNeedShrink = false;
            }
        }
        return false;
    }
}

