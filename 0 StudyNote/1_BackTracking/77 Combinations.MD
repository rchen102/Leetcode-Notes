### Solution1: backtrack 
T： O(n! / (n-k)!k!)

```java
backtrack(list, new ArrayList<Integer>(), n, k, 1);
	
for(int i = start; i <= n; i++) {
    tempList.add(i);
    backtrack(list, tempList, n, k, i + 1);
    tempList.remove(tempList.size() - 1);
}
```
First, there is nothing wrong with using `O(n! / (n-k)!k!)` or any other function `f(n)` as `O(f(n))`, but I believe you are looking for a simpler solution that still holds the same set.

If you are willing to look at the size of the subset k as constant

For `k<=n-k`:
`n! / ((n-k)!k!) = ((n-k+1) (n-k+2) (n-k+3) ... n ) / k!`

But the above is actually `(n^k + O(n^(k-1))) / k!`, which is in `O(n^k)`

Similarly, if `n-k<k`, you get `O(n^(n-k))`, which gives us `O(n^min{k,n-k})`
