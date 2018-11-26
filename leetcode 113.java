//Solution1: recursive backtracking dfs T: O(n) S: O(n) worst
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {  // This is a leaf
            if (root.val == sum) res.add(new ArrayList<>(tmp));
        } else { // This is not a leaf
            helper(root.left, sum - root.val, res, tmp);
            helper(root.right, sum - root.val, res, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}