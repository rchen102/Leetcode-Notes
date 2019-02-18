### 1 Define it

The basic idea behind backtrack is DFS. Build a graph or tree from all the state space of solution.

### 2 When use it

当问题是要求满足某种性质（约束条件）的所有解或最优解时，往往使用回溯法。
	

### 3 Steps:

Backtracking can be solved always as follows:
```
Pick a starting point.
while (Problem is not solved)
    For each path from the starting point.
        check if selected path is safe, if yes select it
        and make recursive call to rest of the problem
        before which undo the current move.
    End For
If none of the move works out, return false, NO SOLUTON.
```
	
### 4 Common examples 
[Link](https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)?page=1)

- Permutations : 46; 47
- Subset: 78;90
- Combination sum: 39; 40;216

#### Permutation

```java
// Key: No duplicate
if(tempList.contains(nums[i])) continue;  

// Key: Duplicate exists
// sort first 
if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; 
```

#### Subset

```java
// Key: No duplicate
list.add(new ArrayList<>(tempList)); 
for(int i = start; i < nums.length; i++)    
// Key: Duplicate exists
// sort first 
list.add(new ArrayList<>(tempList));  
for(int i = start; i < nums.length; i++) 
    if(i > start && nums[i] == nums[i-1]) continue;  // skip duplicates  
```		

#### Combination Sum

```java
// Key: can reuse numbers
// sort        
if(remain < 0) return;
else if(remain == 0) list.add(new ArrayList<>(tempList));
else{ 
for(int i = start; i < nums.length; i++)
    tempList.add(nums[i]);
    backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements 
	
// Key: can not reuse numbers
for(int i = start; i < nums.length; i++)
    if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
    tempList.add(nums[i]);
    backtrack(list, tempList, nums, remain - nums[i], i + 1);   
```		
	
