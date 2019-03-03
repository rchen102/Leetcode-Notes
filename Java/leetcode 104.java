/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive DFS T: O(n) S: O(n) worst
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return(1+Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}

//Solution2: iterative BFS T: O(n) S: O(n+1/2)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 0;
        while(!queue.isEmpty()) {
            deep++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return deep;
    }
}