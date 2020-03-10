// Solution1: HashMap + encoding function 
// T: O(n * k) S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String tag = this.encode(str);
            
            if (!map.containsKey(tag)) {
                map.put(tag, new ArrayList<>());
            }
            map.get(tag).add(str);
        }
        return new ArrayList<>(map.values());
    }
    
    private String encode(String str) {
        char[] code = new char[26];      // ASCLL = 0 by default
        for (char ch : str.toCharArray()) {
            code[ch-'a'] += 1;
        }
        return String.valueOf(code);
    }
}

// Solution2: HashMap + sort
// T: O(n * klogk) S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String tag = String.valueOf(chs);
            
            if (!map.containsKey(tag)) {
                map.put(tag, new ArrayList<>());
            }
            map.get(tag).add(str);
        }
        return new ArrayList<>(map.values());
    }
}