/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: BFS iterative  T： O(n) S: O(n) (node: (n+1) / 2)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(tmp);
        }
        return res;
    }
}

//Solution2: DFS recursive T： O(n) S: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(res.size() == level) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(root.val);
            res.add(tmp);
        }
        else {
            List<Integer> tmp = res.get(level);
            tmp.add(root.val);
        }
        helper(res, root.left, level+1);
        helper(res, root.right, level + 1);
    } 
}