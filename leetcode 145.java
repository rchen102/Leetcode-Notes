/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Solution1: iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur;
        stack.push(root);
        while(!stack.empty()) {
            cur = stack.pop();
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
            else
                list.add(cur.val);
        }
        return list;
    }
}

//Solution2: recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root != null)
            helper(list, root);
        return list;
    }
    
    private void helper(List<Integer> list, TreeNode cur) {
        if(cur.left != null)
            helper(list, cur.left);
        if(cur.right != null)
            helper(list, cur.right);
        list.add(cur.val);
    }
}

//Solution3: HashMap
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<>();
        
        if(root == null)
            return list;
        
        stack.push(root);
        map.put(root, 0);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(map.get(cur) == 1) {
                list.add(cur.val);
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
        return list;
    }
    
}