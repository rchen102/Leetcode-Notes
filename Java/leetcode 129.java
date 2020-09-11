/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: pre-order recursive T: O(n) S: O(h) h = logn
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode cur, int pathSum) {
        if (cur == null) return pathSum;
        pathSum = pathSum * 10 + cur.val;
        if (cur.left == null && cur.right == null) return pathSum;
        
        // 如果不是叶子节点，则还不能返回当前的 pathSum，而是将 pathSum 作为参数继续计算
        int res = 0;
        if (cur.left != null) {
            res += dfs(cur.left, pathSum);
        }
        if (cur.right != null) {
            res += dfs(cur.right, pathSum);
        }
        return res;
    }
}

//Solution2: iterative bfs double queue T: O(n) S: O(n/2)
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Queue<Integer> num = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;  // Store the final result
        
        queue.offer(root);
        num.offer(root.val);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int sum = num.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                int tmp = sum * 10 + cur.left.val;
                num.offer(tmp);
            } 
            if (cur.right != null) {
                queue.offer(cur.right);
                int tmp = sum * 10 + cur.right.val;
                num.offer(tmp);
            }
            if (cur.left == null && cur.right == null) {
                res += sum;
            }
        }
        return res;
    }
}