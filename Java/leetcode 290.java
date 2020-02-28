// Solution1: HashMap
// T: O(n) S: O(n)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        char[] chs = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (strs.length != chs.length) return false;
        
        Map<Character, Integer> mapChar = new HashMap<>();
        Map<String, Integer> mapStr = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int idx1 = mapChar.getOrDefault(chs[i], -1);
            int idx2 = mapStr.getOrDefault(strs[i], -1);
            
            if (idx1 != idx2) return false;
            mapChar.put(chs[i],i);
            mapStr.put(strs[i],i);
        }
        return true;
    }
}