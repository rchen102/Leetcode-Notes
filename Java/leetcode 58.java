//Own solution: T: O(n) S: O(n)
class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        int len = strs.length;
        return len >= 1 ? strs[len-1].length() : 0;
    }
}

//Own solution2: T: O(n) S: O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int idx = s.length() - 1;
        int res = 0;
        while(idx >= 0 && s.charAt(idx) == ' ') idx--;
        while(idx >= 0 && s.charAt(idx) != ' ') {
            res++;
            idx--;
        }
        return res;
    }
}


//Solution1: T: O(n)
class Solution {
    public int lengthOfLastWord(String s) {
       return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}