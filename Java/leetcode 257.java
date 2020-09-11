/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: dfs T: O(n) S: O(n)(worst)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        dfs(root, "", res);
        return res;
    }
    
    private void dfs(TreeNode cur, String curPath, List<String> res) {
        if (cur == null) return;
        curPath = curPath + cur.val;
        if (cur.left == null && cur.right == null) {
            res.add(curPath.toString());
        }
        curPath = curPath + "->";
        dfs(cur.left, curPath, res);
        dfs(cur.right, curPath, res);
    }
}