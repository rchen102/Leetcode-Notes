// Solution1: stack T: O(n) S: O(n)
class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) res.append(ch);
                stack.push(ch);
            }
            if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) res.append(ch);
            }
        }
        return res.toString();
    }
}

// Solution2: 省略stack T: O(n) S: O(1) (not including result)
class Solution {
    public String removeOuterParentheses(String S) {
        int num = 0; // num of stack
        StringBuilder res = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (num != 0) res.append(ch);
                num++;
            }
            if (ch == ')') {
                num--;
                if (num != 0) res.append(ch);
            }
        }
        return res.toString();
    }
}