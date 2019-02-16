### 1 Define it
	
Dynamic programming is to breaking down an optimization problem into simpler sub-problems, and storing the solution to each sub-problem so that each sub-problem is only solved once.
	
### 2 When use it

- 最优子问题
- 重叠子问题
- 一般只要该问题可以划分成规模更小的子问题，并且原问题的最优解中包含了子问题的最优解，则可以考虑用动态规划解决

### 3 Step:

- 核心：阶段的划分、状态的表示和存储表的设计
- 划分子问题
- 给出最优解的递归式
- 找出临界情况，确定base case
- 按自底向上的方法计算出最优解的值

### 4 Tips
	
- Sometimes you do not need to store the whole DP table in memory, the last two values or the last two rows of the matrix will suffice.
- Memoization
