/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: O(n) S: O(n)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(0, tmp);
        }
        return res;
    }
}