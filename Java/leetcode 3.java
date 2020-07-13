/* Solution: sliding window + Map
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();  // 判断是否重复使用
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > 1) isNeedShrink = true;
           
            while (isNeedShrink) {
                char toRemove = s.charAt(left);
                left++;
                map.put(toRemove, map.get(toRemove) - 1);
                if (toRemove == ch) isNeedShrink = false;
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}

/* Solution: sliding window + array -> hashmap 更快
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[256];  // 判断是否重复使用
        int left = 0, right = 0;
        boolean isNeedShrink = false;
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            
            map[ch]++;
            if (map[ch] > 1) isNeedShrink = true;
            
            while (isNeedShrink) {
                char toRemove = s.charAt(left);
                left++;
                map[toRemove]--;
                if (toRemove == ch) isNeedShrink = false;
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}