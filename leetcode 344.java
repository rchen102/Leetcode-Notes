//Solution1: 2 pointers  T: O(n/2) S: O(n)
class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            char tmp = str[j];
            str[j--] = str[i];
            str[i++] = tmp;
        }
        return new String(str);
    }
}

//Solution2:  T: O(n) S: O(n)
class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i ++) {
            sb.append(str[i]);
        }
        return sb.reverse().toString();
    }
}