/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive DFS T: O(n) S: O(logn)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}

//Solution2: iterative BFS T: O(n) S: O(n+1/2)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}

//Solution13: so complicated way
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left != null && root.right != null) {
            return isSameTree(invertTree(root.right), root.left);
        }
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
    
    private TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(p != null && q == null) 
            return false;
        
        if(p.val == q.val) {
            if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}