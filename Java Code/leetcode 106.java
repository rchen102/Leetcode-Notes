/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Own solution: recursive T: O(n^2)(worst) O(nlgn)(best) S: O(n)(wosrt) (O(h))
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if(length < 1) return null;
        return helper(inorder, postorder, 0, length-1, 0, length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int i, int j, int m, int n) {
        if(i > j) return null;
        if(i == j) {
            TreeNode p = new TreeNode(inorder[i]);
            return p;
        }
        int num = 0;
        for(int k = i; k <= j; k++) {
            if(inorder[k] == postorder[n]) {
                num = k;
            }
        }
        TreeNode root = new TreeNode(postorder[n]);
        root.left = helper(inorder, postorder, i, num-1, m, m+num-i-1);
        root.right = helper(inorder, postorder, num+1, j, m+num-i, n-1);
        return root;
    }
}

//Solution2: iterative using stack  T: O(n) S: O(n)(wosrt) (O(h))
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if(length < 1) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[length - 1]);
        TreeNode cur = root;
        
        for(int i = length - 2, j = length - 1; i >= 0; i--) {
            if(cur.val != inorder[j]) {
                cur.right = new TreeNode(postorder[i]);
                stack.push(cur);
                cur = cur.right;
            }
            else {
                j--;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j--;
                }
                cur = cur.left = new TreeNode(postorder[i]);
            }
        }
        return root;
    }
}