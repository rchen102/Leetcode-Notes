// SolUtion1: dfs post-order  T: O(n) S: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode cur, long min, long max) {
        if (cur == null) return true;
        if ((long)cur.val <= min || (long)cur.val >= max) return false;
        boolean left = dfs(cur.left, min, cur.val);
        boolean right = dfs(cur.right, cur.val, max);
        return left && right;
    }
}

// Solution2: dfs in-order T: O(n) S: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val <= pre.val) return false;
            
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}