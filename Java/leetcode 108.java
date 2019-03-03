/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: recursive T: O(n) S: O(logn)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2; // avoid overflow
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}