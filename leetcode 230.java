/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Own solution: dfs inorder traversal T: O(n)(worst) S: O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, k);
        return list.get(k-1);
    }
    
    public void helper(TreeNode root, List<Integer> list, int k) {
        if (root.left != null) helper(root.left, list, k);
        if (list.size() == k) return;
        list.add(root.val);
        if (root.right != null) helper(root.right, list, k);
    }
}