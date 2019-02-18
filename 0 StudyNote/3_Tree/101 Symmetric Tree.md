### Solution1: recursive DFS 
T: O(n) S: O(logn)
```
if(left == null || right == null) return left == right;   //Soooo beautiful!
```	
### Solution2: iterative BFS 
T: O(n) S: O(n+1/2)

With the help of queue:
```
queue.offer(left.left);
queue.offer(right.right);
queue.offer(left.right);
queue.offer(right.left);
```
