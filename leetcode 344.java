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