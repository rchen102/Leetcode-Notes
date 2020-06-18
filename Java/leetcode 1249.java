// Solution1: stack + placeholder T: O(n) S: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(i);
            if (ch == ')') {
                if (!stack.isEmpty()) stack.pop();
                else res.setCharAt(i, '$');
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            res.setCharAt(idx, '$');
        }
        return res.toString().replaceAll("\\$", "");
    }
}