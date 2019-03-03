/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive dfs  T: O(n) S: O(logn)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

//Solution2: iterative dfs T: O(n) S: O(n/2)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stackNode.push(root);
        stackSum.push(root.val);
        while (!stackNode.isEmpty()) {
            TreeNode cur = stackNode.pop();
            int tmp = stackSum.pop();
            // Check whether it is a leaf node
            if (cur.left == null && cur.right == null) {
                if (tmp == sum) return true;
            } else {
                if (cur.right != null) {
                    stackNode.push(cur.right);
                    stackSum.push(tmp + cur.right.val);
                }
                if (cur.left != null) {
                    stackNode.push(cur.left);
                    stackSum.push(tmp + cur.left.val);
                }
            }
        }
        return false;
    }
}