// SolUtion1: dfs post-order  T: O(n) S: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, null, null);
    }
    
    private boolean dfs(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        
        return dfs(root.left, min, root) && dfs(root.right, root, max);
    
    }
}

// Solution2: dfs in-order T: O(n) S: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val <= pre.val) return false;
            
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}

// 判断是否是完全二叉树
public boolean isCBST(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean findNULL = false;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                findNULL = true;
            }
            else {
                if (findNULL) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }
    return true;
}