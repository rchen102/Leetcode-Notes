/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: post-order dfs T: O(n) S: O(h)
class Solution {
    public void flatten(TreeNode root) {
        dfs(root, null);
    }
    
    /**
     *  1. flatten root
     *  2. link the list after root
     *  3. return the newHead
     */
    public TreeNode dfs(TreeNode root, TreeNode linkedList) {
        if (root == null) return linkedList;
        linkedList = dfs(root.right, linkedList);
        linkedList = dfs(root.left, linkedList);
        root.right = linkedList;
        root.left = null;
        linkedList = root;
        return linkedList;
    }
}

// Solution2: iterative pre-order  T: O(n) S: O(h)
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode dummy = new TreeNode();
        TreeNode prev = dummy;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            // do some with cur
            prev.right = cur;
            cur.left = null;
            cur.right = null;
            prev = cur;
            // push left and child
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
        prev.right = null;
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