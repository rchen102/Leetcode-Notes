### Own solution: recursive 
T: O(n^2)(worst) O(nlgn)(best) S: O(n)

```
private TreeNode helper(int[] preorder, int[] inorder, int i, int j, int m, int n) {
    if(i > j) return null;   // Be careful about when there are only 2 elements, like [1,2],[2,1]
    if(i == j) {
        TreeNode p = new TreeNode(preorder[j]);
        return p;
    }
```	

Time complexity analysis:
> For worst case: only have left or right child, degenerate tree `T(n) = n + T(n-1)`
> For best case: Full tree, `T(n) = 2T(n/2) + O(n)`
	
### Solution2:  iterative using stack    
T: O(n) S: O(n)(wosrt) (O(h))

