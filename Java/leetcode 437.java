/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution1: recursive 
// T: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree)  
// S: O(n)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        res += dfs(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }
    
    // 以 root 为起点的和 = sum 的值
    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }
}


//Solution2: HashMap T: O(n) S: O(n)(worst)
class Solution {
    // key: 从root为起点的和的值（终点不限）, value: 这样的和的个数
    Map<Integer, Integer> map = new HashMap<>();
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        map.put(0, 1);
        return dfs(root, 0, sum);
    }
    
    private int dfs(TreeNode root, int curSum, int sum) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += dfs(root.left, curSum, sum);
        res += dfs(root.right, curSum, sum);
        map.put(curSum, map.get(curSum) - 1);
        
        return res;
    }
}
