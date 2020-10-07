// LinkedHashMap
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) return ch;
        }
        return ' ';
    }
}



// map 中存储 idx+1，避免 0 有歧义
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch] == 0) map[ch] = i+1;
            else if (map[ch] >= 1) map[ch] = -1; // 重复出现了，失去了资格 
        }
        int minIdx = s.length();
        for (int i = 0; i < map.length; i++) {
            if (map[i]-1 >= 0) {
                minIdx = Math.min(minIdx, map[i]-1);
            }
        }
        if (minIdx == s.length()) return ' ';
        return s.charAt(minIdx);
    }
}

// 初始化 map 为 -1
class Solution {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] map = new int[256];
        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[ch] == -1) map[ch] = i;
            else if (map[ch] >= 0) map[ch] = -2; // 重复出现了，失去了资格 
        }
        int minIdx = s.length();
        for (int i = 0; i < map.length; i++) {
            if (map[i] >= 0) {
                minIdx = Math.min(minIdx, map[i]);
            }
        }
        if (minIdx == s.length()) return ' ';
        return s.charAt(minIdx);
    }
}