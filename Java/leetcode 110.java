/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution2: recursive down-top T: O(n) S: O(logn)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}

// post-order iterative T: O(n) S: O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
       
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        
        stack.push(root);
        map.put(root, -2);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(map.get(cur) == -1) {
                int left = cur.left == null ? 0 : map.get(cur.left);
                int right = cur.right == null ? 0 : map.get(cur.right);
                
                if (Math.abs(left - right) > 1) return false;
                map.put(cur, Math.max(left, right) + 1);
            }
            else {
                stack.push(cur);
                map.put(cur, -1);
                if(cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, -2);
                }
                if(cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, -2);
                }
            }
        }
        return true;
    }
}


//Solution1: recursive top-down T: O(nlogn) S: O(logn)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getDepth(TreeNode cur) {
        if(cur == null) return 0;
        return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
    }
}
