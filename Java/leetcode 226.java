/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: recursion pre-order T: O(n) S: O(n) 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode cur) {
        if (cur == null) return;
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
        dfs(cur.left);
        dfs(cur.right);
    }
}

// Solution2: iterative pre-order T: O(n) S: O(n) 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            stack.push(cur.left);
            stack.push(cur.right);
        }
        return root;
    }
}