### Solution1: dynamic programming 
- T: O(n^2 * m) S: O(n)
```java
if(f[j] && wordDict.contains(s.substring(j, i))) f[i] = true;
```
