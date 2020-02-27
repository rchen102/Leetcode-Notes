// Solution1: HashTable 
// T: O(n) S: O(1)
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

// Solution2: HashTable 
// T: O(n) S: O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        String encodeS = this.encode(s);
        String encodeT = this.encode(t);
        if (encodeS.equals(encodeT)) return true;
        return false;
    }
    
    private String encode(String str) {
        char[] encode = new char[26];
        if (str == null) return String.valueOf(encode);
        for (char ch : str.toCharArray()) {
            encode[ch-'a'] += 1;
        }
        return String.valueOf(encode);
    }
}

// Solution 3: HashMap
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