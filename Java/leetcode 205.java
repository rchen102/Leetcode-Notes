//Own Solution: HashMap T: O(n) S: O(512)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int valueS = mapS.getOrDefault(s.charAt(i), -1);
            int valueT = mapT.getOrDefault(t.charAt(i), -1);
            
            if(valueS != valueT) return false;
            if(valueS == -1) {
                mapS.put(s.charAt(i), i);
                mapT.put(t.charAt(i), i);
            }
        }
        return true;
    }
}


//Solution2: without Hash T: O(n) S: O(512)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if( m1[s.charAt(i)] != m2[t.charAt(i)] ) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}