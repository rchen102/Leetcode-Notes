class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for(int i : alphabet)
            if(i != 0) return false;
        return true;
    }
}

//Solution 2: using HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i)))
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            else
                map.put(t.charAt(i), 0);
        }
        
        for(int i = 0; i < s.length(); i++)
            if(map.get(s.charAt(i)) != 0) return false;
        return true;
        
    }
}