/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: dfs
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int count = countNodes(root.left);
        if(k <= count ) return kthSmallest(root.left, k);
        if(k > count + 1) return kthSmallest(root.right, k - count - 1);
        return root.val;
    }
    
    private int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

//Solution2: dfs in-order recursive
class Solution {
    private static int count = 0;
    private static int num = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTravel(root);
        return num;
    }
    
    private void inorderTravel(TreeNode root) {
        if(root.left != null) inorderTravel(root.left);
        count--;
        if(count == 0)
            num = root.val;
        if(root.right != null) inorderTravel(root.right);
    }
}