### Solution1: recursive backtrack dfs  
T: O(n) S: O(n) worst

By the help of backtracking, create a helper function, it will keep the result and tmp list for checking.
```
tmp.add(root.val);
if (root.left == null && root.right == null) {  // This is a leaf
    if (root.val == sum) res.add(new ArrayList<>(tmp));
} else { // This is not a leaf
    helper(root.left, sum - root.val, res, tmp);
    helper(root.right, sum - root.val, res, tmp);
}
tmp.remove(tmp.size() - 1);
```
