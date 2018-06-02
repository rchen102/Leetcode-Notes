//Solution1: HashSet T: O(n) S: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            if(!set.add(tmp))
                repeated.add(tmp);
        }
        return new ArrayList<>(repeated);
    }
}

//Solution2: bit manipulation and HashSet  T: O(n) S: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 10) return list;
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();
        
        //coding of a 10-letter sequence into a 4-bytes number
        char[] map = new char[26];
        //A:00 
        map['C'-'A'] = 1; //C:01 
        map['G'-'A'] = 2; //G:10 
        map['T'-'A'] = 3; //T:11 
        
        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!set.add(v) && repeated.add(v)) {
                list.add(s.substring(i, i + 10));
            }
        }
        return list;
    }
}

//Solution2: follow up 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 10) return list;
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();
        
        //coding of a 10-letter sequence into a 4-bytes number
        char[] map = new char[26];
        //A:00 
        map['C'-'A'] = 1; //C:01 
        map['G'-'A'] = 2; //G:10 
        map['T'-'A'] = 3; //T:11 
        
        int v = 0;
        for(int i = 0; i < s.length(); i++) {
            v <<= 2;
            v |= map[s.charAt(i) - 'A'];
            v &= 0xfffff;
            if(i < 9)
                continue;
            if(!set.add(v) && repeated.add(v)) {
                list.add(s.substring(i - 9, i + 1));
            }
        }
        return list;
    }
}