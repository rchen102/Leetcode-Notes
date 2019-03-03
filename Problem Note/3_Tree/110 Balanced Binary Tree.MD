### Solution1: recursive down-top 
T: O(n) S: O(logn)

The solution is based on DFS. Instead of calling `getDepth()` for each child node, we return the height of the current node in DFS recursion. When the sub tree of the current node is balance, the function return the height, otherwise it will `return -1`
	
### Solution2: recursive 
T: O(n^2) S: O(logn)

The solution checks whether the tree is balanced strictly according to the definition of balanced binary tree, it is top down solution.

For the current node root, calling `getDepth()` for its left and right children actually has to acceess all of its children, thus the complexity is `O(n)`, we do this for each level in the tree, so the overall complexity of isBalanced will be `O(nlogn)`
```
if(root == null) return true;
int left = getDepth(root.left);
int right = getDepth(root.right);
return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
```
