### Solution1: 
T: O(2^(2n)) S: O(n)

For this question, we can use the backtracking. 

We only add `(` or `)` that we now will guarantee us a solution.

How to guarantee it? In the helper function, we set `2` variable close and open, which represent the number of close parentheses and open parentheses. Only when `open < n`, we add `(`, only when `close < open` we add `)`.

For time complexity:
`T(N) = 2T(N-1) => O(2^N)  N = 2n`