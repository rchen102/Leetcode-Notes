// Solution1: stack + placeholder T: O(n) S: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return s;
        char[] seq = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < seq.length; i++) {
            char ch = seq[i];
            if (ch == '(') stack.push(i);
            if (ch == ')') {
                if (stack.isEmpty()) {
                    seq[i] = '$'; // 占位符
                }
                else {
                    stack.pop();
                }
            }
        } 
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            seq[idx] = '$';
        }
        StringBuilder res = new StringBuilder();
        for (char ch : seq) {
            if (ch != '$') res.append(ch);
        }
        return res.toString();
    }
}