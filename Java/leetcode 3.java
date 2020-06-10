/* Solution: sliding window + set
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0; // sliding window
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                res = Math.max(res, set.size());
                right++;
            } else {
                while (set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return res;
    }
}

/* Solution: sliding window + array -> hashmap
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                maxLen = Math.max(right - left + 1, maxLen);
                map[s.charAt(right)]++;
                right++;
            }
            else {
                while (map[s.charAt(right)] != 0) {
                    map[s.charAt(left)] = 0;
                    left++;
                }
            }
        }
        return maxLen;
    }
}