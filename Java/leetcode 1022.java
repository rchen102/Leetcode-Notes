class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode cur, int pathSum) {
        if (cur == null) return pathSum;
        pathSum = (pathSum << 1) + cur.val;
        if (cur.left == null && cur.right == null) return pathSum;
        int res = 0;
        if (cur.left != null) res += dfs(cur.left, pathSum);
        if (cur.right != null) res += dfs(cur.right, pathSum);
        return res;
    }
}