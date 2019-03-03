// Solution1: sliding window(2 pointers + map) T: O(n) S: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (right != len) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            } 
            map.put(ch, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}