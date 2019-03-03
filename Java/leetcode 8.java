// Solution1: T: O(n) S: O(1)
class Solution {
    public int myAtoi(String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        int idx = 0;
        while (idx < len && ch[idx] == ' ') idx++;
        if (idx >= len) return 0; 
        
        int flag = 1; // 1: Positive -1: negative
        if (ch[idx] == '+' || ch[idx] == '-') {
            flag = (ch[idx] == '+' ? 1 : -1); 
            idx++;
        }
        int res = 0;
        while (idx < len && ch[idx] >= '0' && ch[idx] <= '9') {
            int newRes = res * 10 + (ch[idx] - '0');
            if (newRes / 10 != res) {
                return (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = newRes;
            idx++;
        }
        return res * flag;
    }
}