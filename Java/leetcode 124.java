// Solution: post-order recursive
class Solution {

    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = root.val;
        maxPathEndWith(root);
        return res;
    }

    int maxPathEndWith(TreeNode cur) {
        if (cur == null) return 0;
        int left = Math.max(0, maxPathEndWith(cur.left));
        int right = Math.max(0, maxPathEndWith(cur.right));
        int maxPath = left + right + cur.val;
        res = Math.max(res, maxPath);
        return Math.max(left, right) + cur.val;
    }
}


// Solution: post-order iterative
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        HashMap<TreeNode, Integer> pathEnd = new HashMap<>();
        stack.push(root);
        map.put(root, 1);
        int res = root.val;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (map.get(cur) == 0) {
                int left = cur.left == null ? 0 : Math.max(0, pathEnd.get(cur.left));
                int right = cur.right == null ? 0 : Math.max(0, pathEnd.get(cur.right));
                res = Math.max(res, left + right + cur.val);
                pathEnd.put(cur, Math.max(left, right) + cur.val);
            }
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