/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive dfs T: O(n) S: O(h) h = logn
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return helper(0, root);
    }
    
    public int helper(int tmp, TreeNode root) {
        tmp = tmp * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmp;
        } else {
            int sum = 0;
            if (root.left != null) sum += helper(tmp, root.left);
            if (root.right != null) sum += helper(tmp, root.right);
            return sum;
        }
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