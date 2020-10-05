class Solution {
    public int minInsertions(String s) {
        if (s == null || s.length() == 0) return 0;
        int need = 0;  // 对右括号的需要数量
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }
            else if (ch == ')') {
                need--;
                if (need < 0) {
                    need = 1;
                    res++;  // 插入一个左括号，这样只需要 1 个右括号即可匹配
                }
            }
        }
        return res + need;
    }
}