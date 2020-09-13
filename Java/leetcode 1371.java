class Solution {
    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int hash = 0;
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(hash, -1);
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (s.charAt(i) == vowels[j]) {
                    hash ^= (1 << j);
                }
            }
            map.putIfAbsent(hash, i);
            res = Math.max(res, i - map.get(hash));
        }
        return res;
    }
}