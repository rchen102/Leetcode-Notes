### Solution1: dynamic programming 
T: O(n) (n: the number of elements) S: O(n) (n: the number of rows)

Bottom-up way:
```
for(int j = 0; j < tmp.size(); j++) {
	sum[j] = Math.min(sum[j], sum[j+1]) + tmp.get(j);
}
```
