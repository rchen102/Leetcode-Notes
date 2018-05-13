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