// Solution1: T: O(m * n) S: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < pre.length()) {
            while (strs[i].indexOf(pre) != 0) 
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}