/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: dfs recursive T: O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }
    
    public void dfs(TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        dfs(cur.left, res);
        dfs(cur.right, res);
        res.add(cur.val);
    }
}

//Solution2: HashMap T: O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (map.get(cur) == 0) res.add(cur.val);
            else {
                stack.push(cur);
                map.put(cur, 0);
                if (cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, 1);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, 1);
                }
            }
        }
        return res;
    }
}

// Solution3: 破坏原结构性 iterative  T：O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                res.add(cur.val);
            }
            else {
                stack.push(cur);
                if (cur.right != null) {
                    stack.push(cur.right);
                    cur.right = null;
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                    cur.left = null;
                }
            }
        }
        return res;
    }
}
