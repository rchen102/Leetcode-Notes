/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution1: BFS iterative  T： O(n) S: O(n) (node: (n+1) / 2)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}

//Solution2: DFS recursive T： O(n) S: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) return;
        List<Integer> tmp;
        if(level == res.size()) {
            // 第一次到达该层
            tmp = new LinkedList<>();
            res.add(tmp);
        }
        else {
            tmp = res.get(level); 
        }
        tmp.add(cur.val);
        dfs(cur.left, res, level + 1);
        dfs(cur.right, res, level + 1);
    }
}