78:
### Solution1: backtracking 
- T: O(2^n) S: O(n)
```java
private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
	list.add(new ArrayList<>(tempList));
```	

### Solution2: Bit manipulation 
- T: O(2^n) S: O(n)

```java
int subsetNum = 1 << nums.length;
for(int i = 0; i < subsetNum; i++) {
```

79:
### Solution1: Backtracking 
- T: O(2^n) S: O(n)
	
It is similar to problem 47, we just obey a rule we only use the element only if its previous element is used.