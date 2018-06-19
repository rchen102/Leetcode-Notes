/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive T: O(n) S: O(h) h = logn
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode cur, int sum) {
        if(cur == null) return 0;
        if(cur.left == null && cur.right == null) return sum * 10 + cur.val;
        return helper(cur.left, sum * 10 + cur.val) + helper(cur.right, sum * 10 + cur.val);
    }
}

//Solution2: iterative T: O(n) S: O(n/2)
class Solution {
 
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        nodeStack.push(root);
        strStack.push(String.valueOf(root.val));
        while(!nodeStack.isEmpty()) {
            TreeNode cur = nodeStack.pop();
            String str = strStack.pop();
            if(cur.left != null) {
                nodeStack.push(cur.left);
                strStack.push(str + String.valueOf(cur.left.val));
            }
            if(cur.right != null) {
                nodeStack.push(cur.right);
                strStack.push(str + String.valueOf(cur.right.val));
            }
            if(cur.left == null && cur.right == null) {
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }
}