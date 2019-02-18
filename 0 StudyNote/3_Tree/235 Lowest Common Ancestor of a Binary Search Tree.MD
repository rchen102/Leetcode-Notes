Just walk down from the whole tree's root as long as both p and q are in the same subtree (which means their value both larger or smaller than root's)

### Solution1: iterative using the definition of a BST  
T: O(logn) S: O(1)

```
while((root.val - p.val) * (root.val - q.val) > 0)
    root = p.val < root.val ? root.left : root.right;
return root;
```

### Solution2: recursive  
T: O(logn) S: O(logn)

```
if(root.val > p.val && root.val > q.val)
    return lowestCommonAncestor(root.left, p, q);
else if(root.val < p.val && root.val < q.val)
    return lowestCommonAncestor(root.right, p, q);
return root;
```