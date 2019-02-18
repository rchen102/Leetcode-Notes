96 Template
### Solution1: Dynamic Programming 
T: O(n^2) S: O(n)

Given a sequence `1..n`, to construct a Binary Search Tree out of the sequence, we could enumerate each number `i` in the sequence, and use the number as the root

Naturally, the subsequence `1..(i-1)` on its left side would lay on the left branch of the root, and similarly the right sbsequence `(i+1)..n` lay on the right branch of the root.

95: Get real tree
### Own solution: Dynamic Programming  
T: O(Catalan(n))  
```
if(start > end) res.add(null);  // Important part
```
