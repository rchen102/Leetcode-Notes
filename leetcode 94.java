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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        help(root, res);
        return res; 
    }
    
    public void help(TreeNode root, List<Integer> res) {
        if(root == null) return;
        help(root.left, res);
        res.add(root.val);
        help(root.right, res);
    }
}


//Solution2: iterative T： O(n) S: O(n) worst
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while(cur != null || !stack.empty()) 
        {
            while(cur != null) 
            {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

//Solution3: HashMap T: O(n) S: O(n) worst
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<>();
        
        if(root == null) return list;
      
        stack.push(root);
        map.put(root, 0);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(map.get(cur) == 1) {
                list.add(cur.val);
                map.remove(cur);
            }
            else {
                if(cur.right != null) {
                    stack.push(cur.right);
                    map.put(cur.right, 0);
                }
                
                stack.push(cur);
                map.put(cur, 1);
                
                if(cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, 0);
                }
            }
        }     
        return list;
    }
}