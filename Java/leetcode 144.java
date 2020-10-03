/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: recursive T: O(n) S: O(n) worst
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    public void dfs(TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        res.add(cur.val);
        dfs(cur.left, res);
        dfs(cur.right, res);
    }
}

// Solutuon2: iterative T: O(n) S: O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            res.add(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return res;
    }
}

// Solution3: HashMap T: O(n) S: O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
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
                if(cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, 0);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, 0);
                }
                stack.push(cur);
                map.put(cur, 1);
            }
        }
        return res;
    }
}


