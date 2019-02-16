//Solution1: T: O(n * klogk) S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String tmp = String.valueOf(ca);
            if(!map.containsKey(tmp))
                map.put(tmp, new ArrayList<String>());
            map.get(tmp).add(str);
                
        }
        return new ArrayList<>(map.values());
    }
}

//Solution2: T: O(n * k) S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String tmp = encode(str);
            if(!map.containsKey(tmp))
                map.put(tmp, new ArrayList<String>());
            map.get(tmp).add(str);
                
        }
        return new ArrayList<>(map.values());
    }
    
    private String encode(String str) {
        char[] freq = new char[26];
        for(char c : str.toCharArray())
            freq[c-'a'] += 1;
        return new String(freq);
    }
}

//Own way: T: O(n^2 * k) S: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] used = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
            if(used[i] == 1) continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(strs[i]);

            for(int j = i + 1; j < strs.length; j++) {
                if(isAnagram(strs[i], strs[j])) {
                    used[j] = 1;
                    tmp.add(strs[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
    
    private boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for(int i : alphabet)
            if(i != 0) return false;
        return true;
    }
}