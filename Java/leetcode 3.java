/* Solution: sliding window + HashMap
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // helper data structure to check duplicate
        int maxLen = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                maxLen = Math.max(maxLen, right - left + 1);
                map.put(ch, 1);
                right++;
            }
            else {
                while (map.containsKey(ch)) {
                    char tmp = s.charAt(left);
                    map.remove(tmp);
                    left++;
                }
            }
        }
        return maxLen;
    }
}


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