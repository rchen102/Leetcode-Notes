/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: Dynamic Programming T: O(Catalan(n)) 
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<>();
        return dp(1, n);
    }
    
    private List<TreeNode> dp(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftRes = dp(start, i - 1);
            List<TreeNode> rightRes = dp(i + 1, end);
            for (TreeNode left : leftRes) {
                for (TreeNode right : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}