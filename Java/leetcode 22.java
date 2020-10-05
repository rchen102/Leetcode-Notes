//Solution1: T: O(2^(2n)) S: O(n)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtrack(n, n, new StringBuilder(2*n), res);
        return res; 
    }

    void backtrack(int left, int right, StringBuilder path, List<String> res) {
        if (left < 0 || right < 0) return; // 剩余为负数，不合法
        if (left > right) return; // 剩下的左括号多，不合法
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        // 尝试左括号
        path.append('(');
        backtrack(left - 1, right, path, res);
        path.deleteCharAt(path.length() - 1);

        // 尝试右括号
        path.append(')');
        backtrack(left, right - 1, path, res);
        path.deleteCharAt(path.length() - 1);
    }
}