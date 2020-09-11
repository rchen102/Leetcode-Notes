/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution1: dfs inorder traversal T: O(n) S: O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, k);
        return list.get(k-1);
    }
    
    private void dfs(TreeNode cur, List<Integer> list, int k) {
        if (cur == null || list.size() >= k) return;
        dfs(cur.left, list, k);
        list.add(cur.val);
        dfs(cur.right, list, k);
    }
}

// Solution2: in-order iterative T: O(n) S: O(logn) O(n) worst
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int counter = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            counter++;
            if (counter == k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}