## 102 level order: Template; 103 zigzag; 107 bottom-top

### Solution1: BFS iterative  
T： O(n) S: O(n) (node: (n+1) / 2)

Use the size() of stack to do a for loop

By help of queue
	
### Solution2: DFS recursive 
T： O(n) S: O(n)

Pass the level number as a parameter

By a helper function
	
### For 103:
BFS: add variable level, when it is odd, use `list.add(0, node)`

DFS: just check level is even or odd

### For 107:
BFS: just use `list.add(0, node)`

DFS: can not use `res.get(level)` anymore, so better avoid, or get `res` then reverse it
