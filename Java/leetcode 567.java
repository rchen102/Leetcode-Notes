// Solution1: sliding window
// Array + isAllZero，固定滑动窗口模板
// T: O(n) S: O(1)
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

// Solution2: sliding window
// Array + isAllZero，经典滑动窗口模板
// T: O(n) S: O(1)
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

// Solution3: sliding window
// HashMap + valid，经典滑动窗口模板
// T: O(n) S: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0 || s1 == null || s1.length() == 0) return false;
        // helper variables
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int valid = 0;
        
        // sliding window
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if ((int) window.get(ch) == (int) need.get(ch)) valid++;
                if (valid == need.size()) return true;
            }
            if (right - left >= s1.length()) isNeedShrink = true;
                        
            while (isNeedShrink) {
                char leave = s2.charAt(left);
                left++;
                
                if (need.containsKey(leave)) {
                    if ((int) window.get(leave) == (int) need.get(leave)) valid--;
                    window.put(leave, window.getOrDefault(leave, 0) - 1);
                }
                if (right - left < s1.length()) isNeedShrink = false;
            }
        }
        return false;
    }
}