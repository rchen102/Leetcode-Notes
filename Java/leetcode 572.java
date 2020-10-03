class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val == t.val && isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t); 
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        if (root1.val != root2.val) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}