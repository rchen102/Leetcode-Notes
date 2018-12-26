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
        List<String> list = new ArrayList<>();
        if(root != null) search(list, "", root);
        return list;
    }
    
    private void search(List<String> list, String str, TreeNode cur) {
        if(cur.left == null && cur.right ==null) list.add(str + cur.val);
        if(cur.left != null)
            search(list, str + cur.val + "->", cur.left);
        if(cur.right != null)
            search(list, str + cur.val + "->", cur.right);
    }
}