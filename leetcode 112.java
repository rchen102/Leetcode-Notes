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
        if(root == null) return false;
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        stack.push(root);
        num.push(root.val);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int tmp = num.pop();
            
            if(cur.left == null && cur.right == null) {
                if(tmp == sum) return true;
            } 
            else {
                if(cur.right != null) {
                    stack.push(cur.right);
                    num.push(tmp + cur.right.val);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                    num.push(tmp + cur.left.val);
                }
            }
        }
        return false;
    }
}