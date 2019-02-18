### Solution1: recursive dfs 
T: O(n) S: O(logn)
```
if(root == null || root.left == null) return;
```

### Solution2: iterative bfs 
T: O(n) S: O(1)
	
Do the level order traversal without help of queue (why? because we have the help of next pointer.)
- Loop through all the levels from top to down
- Traverse this level and connect children
	
### Own way: level traversal bfs 
T: O(n) S: O(n+1/2) (wide)
	
Just do the level order traversal with queue
