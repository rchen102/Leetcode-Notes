### Solution1: recursive dfs  
T: O(n) S: O(logn)
```
if(root == null) return false;
if(root.left == null && root.right == null) return root.val == sum;
else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
```
### Solution2: iterative dfs 
T: O(n) S: O(n/2)

Do dfs traversal (inorder), use 2 stacks, one for node, one for the sum from the root to the node.
```
Stack<TreeNode> stack = new Stack<>();
Stack<Integer> num = new Stack<>();

if(cur.right != null) {
    stack.push(cur.right);
    num.push(tmp + cur.right.val);
}
if(cur.left != null) {
    stack.push(cur.left);
    num.push(tmp + cur.left.val);
}
```
