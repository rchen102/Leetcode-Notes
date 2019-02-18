### Solution1: based on level order traversal iterative 
T: O(n) S: O(1)

Still do the level order traversal, but add a previous node to help
```
TreeLinkNode head = root; // The left most node in lower level
TreeLinkNode pre = null; // The previous node in lower level
TreeLinkNode cur = null; // The current node in upper level
```