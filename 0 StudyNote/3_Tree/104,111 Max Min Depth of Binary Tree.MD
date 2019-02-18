104 MAX:
### Solution1: recursive DFS 
T: O(n) S: O(n) worst
```
return(1+Math.max(maxDepth(root.left),maxDepth(root.right)));
```

### Solution2: iterative BFS 
T: O(n) S: O(n+1/2)

With the help of queue, actually it is level traversal

MIN:
### Solution1: recursive DFS 
T: O(n)worst S: O(n)worst

can not do like MAX, for `null` is not child node
```
return (1+Math.min(minDepth(root.left),minDepth(root.right)));
```

Should check whther the child is null, before do recursive dfs