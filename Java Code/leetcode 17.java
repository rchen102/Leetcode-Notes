//Solution2: backtrack bfs T: O(3^n) S: O(1)
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if(digits.length() == 0 || digits == null) return res;
        
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i = 0 ; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i) {
                String str = res.remove();
                for(char s : mapping[x].toCharArray())
                    res.add(str + s);
            }
        }
        return res;
    }
}


//Solution2: backtrack dfs T: O(3^n) S: O(1)
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        helper(res, "", digits, mapping);
        return res;
    }
    
    public void helper(List<String> res, String str, String digits, String[] mapping) {
        if(str.length() == digits.length()) {
            res.add(str);
            return;
        }
        int num = Character.getNumericValue(digits.charAt(str.length()));
        for(char c : mapping[num].toCharArray()) {
            helper(res, str + c, digits, mapping);
        }  
    }
}