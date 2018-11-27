/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive T: O(n) S: O(h)
class Solution {
    public void flatten(TreeNode root) {
        helper(root, null);
    }
    
    private TreeNode helper(TreeNode cur, TreeNode prev) {
        if(cur == null) return prev;
        prev = helper(cur.right, prev);
        prev = helper(cur.left, prev);
        cur.right = prev;
        cur.left = null;
        prev = cur;
        return prev;
    }
}

//Solution2: iterative pre-order search T: O(n) S: O(h)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode start = new TreeNode(0);
        
        TreeNode cur;
        stack.push(root);
        while(!stack.empty()) {
            cur = stack.pop();
            start.right = cur;
            start = cur;
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            }
        }   
    }
}


// Solution3: recursive T: O(nlogn) S: O(n) worst
// More straight, but not the best way
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }       
    }
}