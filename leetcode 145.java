/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: recursive T: O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}

//Solution2: HashMap T: O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();

        if(root == null) return res;
        stack.push(root);
        map.put(root, 0);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(map.get(cur) == 1) {
                res.add(cur.val);
                map.remove(cur);
            }
            else {
                stack.push(cur);
                map.put(cur, 1);
                if(cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, 0);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, 0);
                }
            }
        }
        return res;
    }
}

//Solution3: iterative  T：O(n) S: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null || cur.right != null) {
                stack.push(cur);
                if(cur.right != null) {
                    stack.push(cur.right);
                    cur.right = null;
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                    cur.left = null;
                }
            }
            else res.add(cur.val);
        }
        return res;
    }
}
