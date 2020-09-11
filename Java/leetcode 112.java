/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive post-order  T: O(n) S: O(logn)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, 0, sum);
    }
    
    // pathSum: current path sum, not include cur
    private boolean dfs(TreeNode cur, int pathSum, int sum) {
        if (cur == null) return false;
        pathSum += cur.val;
        if (cur.left == null && cur.right == null) {
            return pathSum == sum;
        }
        return dfs(cur.left, pathSum, sum) || dfs(cur.right, pathSum, sum);
    }
}

//Solution2: iterative dfs T: O(n) S: O(n/2)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        
        stack.push(root);
        sumStack.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int curSum = sumStack.pop();
            if (cur.left == null && cur.right == null) {
                if (curSum == sum) return true;
            }
            if (cur.right != null) {
                stack.push(cur.right);
                sumStack.push(curSum + cur.right.val);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                sumStack.push(curSum + cur.left.val);
            }
        }
        return false;
    }
}