### Solution1: recursive 
T: O(n) S: O(h)

Just take care how to return the final result

### Solution2: iterative bfs double queue 
T: O(n) S: O(n/2)

With help of double queue, do the level oreder traversal.

One queue store the node, the other store the sum from root to the corresponding node. 
