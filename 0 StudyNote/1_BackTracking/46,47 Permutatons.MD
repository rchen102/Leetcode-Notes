46:
### Solution1: backtracking 
T: O(n!) S: O(n)
```
if(tempList.contains(nums[i])) continue;
```

47: 
### Solution1: backtracking 
T: O(n!) S: O(n)

The key point is how to handle the duplicate elements, so we just sort the Array first. Next if we suppose the element of same value are different, like
	
	eg:  `1, 1bar`

Then just get the permutations of them, of course we will get duplicate permutations, now forcus on them, take `1, 1bar, 2` for example

	2,1,1bar
	2,1bar,1

How to get rid of one of them, the solution is easy, we can obey a rule that we use the number only if its previous is used, like we will not use `1bar`, unless we have used `1`, then we can get a result without duplicates.