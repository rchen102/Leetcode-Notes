/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: recursive DFS T: O(n)worst S: O(n)worst
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; 
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        // 这一步非常重要，判断左右子节点是否为 null
        if (leftMin == 0) return rightMin + 1;
        if (rightMin == 0) return leftMin + 1;
        return Math.min(leftMin, rightMin) + 1;
    }  
}

// Solution2: iterative BFS T: O(n)worst S: O(n+1/2)
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == cur.right) return depth;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;  
    }  
}