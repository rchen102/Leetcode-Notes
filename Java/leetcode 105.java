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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length < 1) return null;
        return helper(preorder, inorder, 0, length-1, 0, length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int i, int j, int m, int n) {
        if(i > j) return null;
        if(i == j) {
            TreeNode p = new TreeNode(preorder[j]);
            return p;
        }
        int num = 0;
        for(int k = m; k <= n; k++) {
            if(inorder[k] == preorder[i]) {
                num = k;
            }
        }
        TreeNode root = new TreeNode(preorder[i]);
        root.left = helper(preorder, inorder, i+1, i+num-m, m, num-1);
        root.right = helper(preorder, inorder, i+num-m+1, j, num+1, n);
        return root;
    }
}

//Solution2: iterative using stack  T: O(n) S: O(n)(wosrt) (O(h))
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length < 1) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        
        for(int i = 1, j = 0; i < length; i++) {
            if(cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur);
                cur = cur.left;
            }
            else {
                j++;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    cur = stack.pop();
                    j++;
                }
                cur.right = new TreeNode(preorder[i]);
                cur = cur.right
            }
        }
        return root;
    }
}