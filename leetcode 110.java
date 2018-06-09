/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: recursive top-down T: O(nlogn) S: O(logn)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getDepth(TreeNode cur) {
        if(cur == null) return 0;
        return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
    }
}


//Solution2: recursive down-top T: O(n) S: O(logn)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    private int helper(TreeNode cur) {
        if(cur == null) return 0;
        
        int left = helper(cur.left);
        if(left == -1) return -1;
        int right = helper(cur.right);
        if(right == -1) return -1;
        
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left,right) + 1;
    }
}