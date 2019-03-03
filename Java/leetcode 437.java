/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Solution1: recursive 
//T: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree)  
//S: O(n)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}

//Solution2: HashMap T: O(n) S: O(n)(worst)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }
    
    // Will return the number of path 
    private int helper(TreeNode root, int curSum, int sum, Map<Integer, Integer> map) {
        if(root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);
        map.put(curSum, map.get(curSum) - 1);

        return res;
    }
}


//Solution: own way 
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res += helper(cur, sum);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
    
    private int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        return (root.val == sum ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}