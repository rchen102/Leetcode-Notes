### Solution1: recursive down-top  
T: O(n) S: O(h)

Using a reverse-pre-order search.
```
private TreeNode helper(TreeNode cur, TreeNode prev) {
    if(cur == null) return prev;
    prev = helper(cur.right, prev);
    prev = helper(cur.left, prev);
    cur.right = prev;
    cur.left = null;
    prev = cur;
    return prev;
}
```

### Solution2: iterative pre-order search top-down 
T: O(n) S: O(h) 

```
while(!stack.empty()) {
    cur = stack.pop();
    start.right = cur;
    start = cur;
    if(cur.right != null)
        stack.push(cur.right);
    if(cur.left != null) {
        stack.push(cur.left);
        cur.left = null;
    }
}  
``` 
