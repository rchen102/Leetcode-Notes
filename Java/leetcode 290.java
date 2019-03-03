//Own solution: HashMap & HashSet T: O(n) S: O(n)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        List<String> list = getStrList(str);
        if(pattern.length() != list.size()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char s = pattern.charAt(i);
            if(map.containsKey(s)) {
                if(!map.get(s).equals(list.get(i))) return false; 
            } else {
                if(!set.add(list.get(i))) return false;
                map.put(s, list.get(i));
            }
        }
        return true;
    }
    
    public List<String> getStrList(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        for(int j = 0; j < str.length(); j++) {
            if(str.charAt(j) == ' ') {
                list.add(str.substring(start, j));
                start = j + 1;
            } 
        }
        list.add(str.substring(start, str.length())); // Do not forget to add final element
        return list;
    }
}

//Solution1: more concise
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] list = str.split(" ");
        if(pattern.length() != list.length) return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(Integer i = 0; i < pattern.length(); i++) {
            if(map.put(pattern.charAt(i), i) != map2.put(list[i], i)) return false;
        }
        return true;
    }
}