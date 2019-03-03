/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive T: O(n) S: O(n) worst
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}

// Solution2: iterative By 2 stack T: O(n) S: O(n) worst
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if (cur1.val != cur2.val) return false;
            if (cur1.right == null || cur2.right == null) {
                if (cur1.right != cur2.right) return false; 
            } else {
                stack1.push(cur1.right);
                stack2.push(cur2.right);
            }
            if (cur1.left == null || cur2.left == null) {
                if (cur1.left != cur2.left) return false;
            } else {
                stack1.push(cur1.left);
                stack2.push(cur2.left);
            }
        }
        return stack1.size() == stack2.size();
    }
}