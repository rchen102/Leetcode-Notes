/* Solution: sliding window + HashMap
 * T: O(n) S: O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch) || map.get(ch) < left) {
                map.put(ch, right);
                right++;
                maxLen = Math.max(right - left, maxLen);
            }
            else {
                left = map.get(ch) + 1;
                map.put(ch, right);
                right++;
            }
        }
        return maxLen;
    }
}