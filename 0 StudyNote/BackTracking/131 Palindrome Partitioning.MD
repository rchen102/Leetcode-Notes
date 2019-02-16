### Solution1: backtracking 
- T: O(n*(2^n)) S: O(n)

For a string with length `n`, there will be `(n - 1)` intervals between chars.

For every interval, we can cut it or not cut it, so there will be `2^(n - 1)` ways to partition the string.

For every partition way, we need to check if it is palindrome, which is `O(n)`.

So the time complexity is `O(n*(2^n))`


