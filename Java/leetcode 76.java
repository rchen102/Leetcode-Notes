// Solution1: sliding window T: O(n) S: O(n)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        
        // helper vars
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int start = -1, len = s.length() + 1;  // final result
        
        // sliding window
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        while (right < s.length()) {
            // 右移
            char c = s.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if ((int) window.get(c) == (int) need.get(c)) valid++;
            }
            if (valid == need.size()) isNeedShrink = true;
            
            while (isNeedShrink) {
                // update result
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 左移
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if ((int) window.get(d) == (int) need.get(d)) valid--;
                    window.put(d, window.get(d) - 1);
                }
                if (valid != need.size()) isNeedShrink = false;
            }
        }
        return start == -1 ? "" : s.substring(start, start + len);
    }
}