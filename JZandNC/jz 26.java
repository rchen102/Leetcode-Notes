class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        boolean res = dfs(A, B);
        if (res) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);        
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;  // B 已经遍历完了
        if (A == null) return false; // A 已经遍历完了，B 还没有
        if (A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}