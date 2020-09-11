// Solution1: recursive backtrace dfs T: O(n) S: O(n) worst
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(TreeNode cur, int remain, List<Integer> curPath, List<List<Integer>> res) {
        if (cur == null) return;
        // update vars with the new step
        curPath.add(cur.val);
        remain -= cur.val;
        
        // do check for current step
        if (cur.left == null && cur.right == null) {
            if (remain == 0) {
                res.add(new ArrayList<>(curPath));
            }
        }
        
        dfs(cur.left, remain, curPath, res);
        dfs(cur.right, remain, curPath, res);
        
        // back one step
        curPath.remove(curPath.size() - 1);
    }
}